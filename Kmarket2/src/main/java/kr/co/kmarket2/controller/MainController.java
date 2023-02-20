package kr.co.kmarket2.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket2.service.CateService;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;

@Controller
public class MainController {

	@Autowired
	private CateService service;
	
	@GetMapping(value = {"", "index"})
	public String index(Principal principal, Model model) {
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		
		return "index";
	}
}
