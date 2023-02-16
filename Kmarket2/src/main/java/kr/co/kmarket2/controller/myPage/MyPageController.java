package kr.co.kmarket2.controller.myPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {
	
	@GetMapping("/myPage/home")
	private String home() {
		
		return "/myPage/home";
		
	}

	@GetMapping("/myPage/info")
	private String info(String uid ) {
		
		return "/myPage/info";
		
	}
	
}
