package kr.co.kmarket2.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping(value = {"/admin", "/admin/index"})
	public String admin() {
		return "/admin/index";
	}
}
