package kr.co.kmarket2.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminIndexController {

	@GetMapping(value = {"admin", "admin/index"})
	public String index() {
		return "admin/index";
	}
}
