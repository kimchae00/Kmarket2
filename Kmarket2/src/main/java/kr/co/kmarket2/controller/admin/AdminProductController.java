package kr.co.kmarket2.controller.admin;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.co.kmarket2.service.AdminService;
import kr.co.kmarket2.service.CateService;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;

@Controller
public class AdminProductController {
	
	@Autowired
	private AdminService service;
	
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
	
	@PostMapping("admin/product/register")
	public String register(ProductVO vo, HttpServletRequest req) {
		String ip = req.getRemoteAddr();
		vo.setIp(ip);
		int result = service.insertProduct(vo);
		
		return "redirect:/admin/product/list";
	}
		
	// cate2 list 불러오기
	@ResponseBody
	@PostMapping("admin/product/cate2s")
	public List<ProdCate2VO> cate2s(int cate1) {
		
		List<ProdCate2VO> cate2s = service.selectCate2(cate1);
		
		/*
		// Gson으로 AJAX 응답
		Gson gson = new Gson();
		String jsonData = gson.toJson(cate2s);
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(jsonData);
		return jsonData;
		*/
		return cate2s;
	}
	
	
}
