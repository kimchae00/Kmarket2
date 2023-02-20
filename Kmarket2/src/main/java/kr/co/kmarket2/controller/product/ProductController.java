package kr.co.kmarket2.controller.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket2.service.ProductService;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping("product/list")
	public String list(Model model, String prodCate1, String prodCate2) {
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		List<ProductVO> products = service.selectProducts(prodCate1, prodCate2);
		
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		model.addAttribute("prodCate1", prodCate1);
		model.addAttribute("prodCate2", prodCate2);
		model.addAttribute("products", products);
		
		return "product/list";
	}
	
	@GetMapping("product/view")
	public String view(Model model) {
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		return "/product/view";
	}
	@GetMapping("product/cart")
	public String cart(Model model) {
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		return "/product/cart";
	}
	@GetMapping("product/order")
	public String order(Model model) {
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		return "/product/order";
	}
	@GetMapping("product/complete")
	public String complete(Model model) {
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		return "/product/complete";
	}
}
