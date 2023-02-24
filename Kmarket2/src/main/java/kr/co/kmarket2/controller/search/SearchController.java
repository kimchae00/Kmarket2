package kr.co.kmarket2.controller.search;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket2.service.MainService;
import kr.co.kmarket2.service.ProductService;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;

@Controller
public class SearchController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private MainService MainService;
	
	@ResponseBody
	@PostMapping(value = {"", "index"})
	public Map<String, List<ProductVO>> index(Model model, @RequestParam("search") String search, HttpSession sess, HttpServletResponse resp) throws IOException {
		Map<String, List<ProductVO>> map = new HashMap<>();
		List<ProductVO> products = MainService.searchProduct(search);
		map.put("products", products);
		
		if(!products.isEmpty()) {
			sess.setAttribute("products", products);
		}
		
		return map;
	}
	
	
	@GetMapping("product/search")
	public String search(Model model, HttpSession sess, String keyword) {
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		
		List<ProductVO> products = (List<ProductVO>) sess.getAttribute("products");
		int result = service.searchProductTotal(keyword);
		
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("products", products);
		model.addAttribute("result", result);
		
		
		// 페이징 처리
		int currentPage = 1;
		int start = (currentPage - 1) * 10;

        int total = result;
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getpageStartNum(total, start);
        int[] groups = service.getPageGroup(currentPage, lastPageNum);

        model.addAttribute("groups", groups);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("start", start);
        model.addAttribute("total", total);
        model.addAttribute("lastPageNum", lastPageNum);
        
		
		return "product/search";
	}
	
	@ResponseBody
	@PostMapping(value = {"product/search"})
	public Map<String, List<ProductVO>> search(Model model, @RequestParam("search") String search, HttpSession sess, HttpServletResponse resp) throws IOException {
		Map<String, List<ProductVO>> map = new HashMap<>();
		List<ProductVO> products = MainService.searchProduct(search);
		map.put("products", products);
		
		if(!products.isEmpty()) {
			sess.setAttribute("products", products);
		}
		
		return map;
	}
	
	
}
