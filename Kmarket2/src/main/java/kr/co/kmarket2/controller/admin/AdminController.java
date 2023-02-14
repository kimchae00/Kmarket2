package kr.co.kmarket2.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("admin/index")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("admin/product/list")
	public String list() {
		return "admin/product/list";
	}
	
	@GetMapping("admin/product/register")
	public String register() {
		return "admin/product/register";
	}
}
