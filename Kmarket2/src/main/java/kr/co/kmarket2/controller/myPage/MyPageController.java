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
	private String info() {
		
		return "/myPage/info";
		
	}
	
	@GetMapping("/myPage/ordered")
	private String ordered() {
		
		return "/myPage/ordered";
		
	}
	
	@GetMapping("/myPage/point")
	private String point() {
		
		return "/myPage/point";
		
	}
	
	@GetMapping("/myPage/qna")
	private String qna() {
		
		return "/myPage/qna";
		
	}
	
	
	@GetMapping("/myPage/review")
	private String review() {
		
		return "/myPage/review";
		
	}
	
	@GetMapping("/myPage/coupon")
	private String coupon() {
		
		return "/myPage/coupon";
		
	}
}
