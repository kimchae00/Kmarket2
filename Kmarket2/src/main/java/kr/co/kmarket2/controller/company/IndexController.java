package kr.co.kmarket2.controller.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping(value = {"company", "company/index"})
	public String index() {
		return "/company/index";
	}
}
