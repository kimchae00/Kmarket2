package kr.co.kmarket2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.ArrayList;
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

import kr.co.kmarket2.service.CateService;
import kr.co.kmarket2.service.MainService;
import kr.co.kmarket2.vo.MemberVO;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping(value = {"", "index"})
	public String index(Principal principal, Model model, String prodCate1, String prodCate2) {
		// 카테 출력
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		// 상품 정렬
		List<ProductVO> solds = service.selectProductsSold();
		List<ProductVO> hits = service.selectProductsHit();
		List<ProductVO> scores = service.selectProductsScore();
		List<ProductVO> lates = service.selectProductsNew();
		List<ProductVO> discounts = service.selectProductsDiscount();
		
		
		
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		model.addAttribute("solds", solds);
		model.addAttribute("hits", hits);
		model.addAttribute("scores", scores);
		model.addAttribute("lates", lates);
		model.addAttribute("discounts", discounts);
		
		return "index";
	}
	

	
	
}
