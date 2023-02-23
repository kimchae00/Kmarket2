package kr.co.kmarket2.controller.product;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket2.security.MyUserDetails;
import kr.co.kmarket2.security.SecurityUserService;
import kr.co.kmarket2.service.ProductService;
import kr.co.kmarket2.vo.CartVO;
import kr.co.kmarket2.vo.MemberVO;
import kr.co.kmarket2.vo.OrderItemVO;
import kr.co.kmarket2.vo.OrderVO;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;
import kr.co.kmarket2.vo.ReviewVO;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping("product/list")
	public String list(Model model, String prodCate1, String prodCate2, String pg, String type, String prodNo) {
		// 카테고리 출력
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		// 페이징 처리
		int currentPage = service.getCurrentPage(pg);
        int start = service.getLimitStart(currentPage);

        int total = 0;
        total = service.selectCountTotal(prodCate1,prodCate2);
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getpageStartNum(total, start);
        int[] groups = service.getPageGroup(currentPage, lastPageNum);

        // 상품 정렬
        List<ProductVO> products = null;
        
        if(type == null) {
        	products = service.selectProducts(start, prodCate1, prodCate2);
        }else if(type.equals("sold")) {
        	products = service.selectProductsBySold(start, prodCate1, prodCate2);
        }else if(type.equals("lowPrice")) {
        	products = service.selectProductsByLowPrice(start, prodCate1, prodCate2);
        }else if(type.equals("highPrice")) {
        	products = service.selectProductsByHighPrice(start, prodCate1, prodCate2);
        }else if(type.equals("score")) {
        	products = service.selectProductsByScore(start, prodCate1, prodCate2);
        }else if(type.equals("review")) {
        	products = service.selectProductsByReview(start, prodCate1, prodCate2);
        }else if(type.equals("new")) {
        	products = service.selectProductsByNew(start, prodCate1, prodCate2);
        }
        	
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		model.addAttribute("prodCate1", prodCate1);
		model.addAttribute("prodCate2", prodCate2);
		model.addAttribute("products", products);
	    model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageStartNum", pageStartNum);
        model.addAttribute("groups", groups);
        model.addAttribute("type", type);
        model.addAttribute("pg", pg);
		
		return "product/list";
	}
	
	@GetMapping("product/view")
	public String view(Model model, String prodCate1, String prodCate2, String prodNo, String pg) {
		// 카테 출력
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		
		// 상품 출력
		ProductVO product = service.selectProduct(prodNo);
		model.addAttribute("prodCate1", prodCate1);
		model.addAttribute("prodCate2", prodCate2);
		model.addAttribute("product", product);
		
	    // 리뷰
		int currentPage = service.getCurrentPage2(pg);
        int start = service.getLimitStart2(currentPage);

        int total = service.selectCountTotalReview(prodNo);
        int lastPageNum = service.getLastPageNum2(total);
        int pageStartNum = service.getpageStartNum2(total, start);
        int groups[] = service.getPageGroup2(currentPage, lastPageNum);
		
        List<ReviewVO> reviews = service.selectReview(prodNo, start);
        model.addAttribute("reviews", reviews);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageStartNum", pageStartNum);
        model.addAttribute("groups", groups);
        model.addAttribute("prodNo", prodNo);
        
		return "product/view";
	}
	
	@ResponseBody
	@PostMapping("product/view")
	public Map<String, Integer> view(CartVO vo, int prodNo) {
		
		Map<String, Integer> map = new HashMap<>();
		int	result = service.insertCart(vo);
		map.put("result", result);
        return map;
	}
	
	@GetMapping("product/cart")
	public String cart(Model model, HttpSession sess, Principal principal, String prodNo, String cartNo) {
		String uid = principal.getName();		
		
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		List<CartVO> cartList = service.selectCart(uid);
		
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		model.addAttribute("cartList", cartList);
		model.addAttribute("cartNo", cartNo);
		model.addAttribute("prodNo", prodNo);
		return "product/cart";
	}
	
	@ResponseBody
	@PostMapping("product/cart")
	public Map<String, Integer> cart(Principal principal, @Param("cartNo") int cartNo) {
		Map<String, Integer> map = new HashMap<>();
		
		int result = service.deleteCartByCartNo(cartNo);
		map.put("result", result);
		
		return map;
	}
	
	@GetMapping("product/order")
	public String order(Model model, Principal principal, @RequestParam(value="cartNo", required=false) ArrayList<String> cartNo, @RequestParam(value="prodNo", required=false)  String prodNo, @RequestParam(value="count", required=false) Integer count) {
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		
		String uid = principal.getName();
		
		List<CartVO> cartList = null;
		ProductVO product = null;
		
		if(prodNo == null) {
			cartList = service.selectCartByCartNo(cartNo);
		}else {
			product = service.selectProduct(prodNo);
		}
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("count", count);
		model.addAttribute("product", product);
		model.addAttribute("principal", principal);
		
		return "product/order";
	}
	
	@PostMapping(value="product/order", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Map<String, Integer> order(@RequestBody OrderVO order){
		int result = service.insertOrder(order);
		
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}

}
