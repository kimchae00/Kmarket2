package kr.co.kmarket2.controller.admin;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;

import kr.co.kmarket2.service.AdminService;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	
	@GetMapping(value = {"admin", "admin/index"})
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("admin/product/list")
	public String list() {
		return "admin/product/list";
	}
	
	@GetMapping("admin/product/register")
	public String register(Model model) {
		List<ProdCate1VO> cate1s = service.selectCate1();
		
		model.addAttribute("cate1s", cate1s);
		
		return "admin/product/register";
	}
	
	/*
	@PostMapping("admin/product/cate2s")
	public String cate2s(HttpServletResponse resp) {
		
		// cate2 불러오기
		List<ProdCate2VO> cate2s = service.selectCate2();
		
		// Gson으로 AJAX 응답
		Gson gson = new Gson();
		String jsonData = gson.toJson(cate2s);
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(jsonData);
	}
	*/
}
