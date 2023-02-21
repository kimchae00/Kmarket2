package kr.co.kmarket2.controller.myPage;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket2.service.MyPageService;
import kr.co.kmarket2.vo.ArticleVO;
import kr.co.kmarket2.vo.MemberVO;

@Controller
public class MyPageController {
	
	@Autowired
	private MyPageService service;
	
	@GetMapping("myPage/home")
	private String home(Principal Principal, Model model) {
		
		String uid = Principal.getName();
		MemberVO info = service.selectUserInfo(uid);
		List<ArticleVO> vo = service.selectQna(uid);

		
		model.addAttribute("info", info);
		model.addAttribute("vo", vo);

		
		return "/myPage/home";
		
	}

	@GetMapping("myPage/info")
	private String info(Principal principal, Model model) {
		
		String uid = principal.getName();
		
		System.out.println("uid : " + uid);
		
		MemberVO info = service.selectUserInfo(uid);
		
		System.out.println("info : " + info);
		
		model.addAttribute("info", info);
		
		
		return "/myPage/info";
		
	}
	
	@GetMapping("myPage/ordered")
	private String ordered() {
		
		return "/myPage/ordered";
		
	}
	
	@GetMapping("myPage/point")
	private String point() {
		
		return "/myPage/point";
		
	}
	
	@GetMapping("myPage/qna")
	private String qna(Principal principal, Model model, String pg) {
		String uid = principal.getName();
		
		int currentPage = service.getCurrentPage(pg);
		int start = service.getLimitStart(currentPage);
		
		int total = service.selectCountTotal(uid);
		int lastPageNum = service.getLastPageNum(total);
		int pageStartNum = service.getPageStartNum(total, start);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);

		MemberVO info = service.selectUserInfo(uid);
		List<ArticleVO> vo = service.selectQnaMore(uid, start);
		
		model.addAttribute("info", info);
		model.addAttribute("vo", vo);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("groups", groups);
		
		
	
		return "/myPage/qna";
		
	}
	
	
	@GetMapping("myPage/review")
	private String review() {
		
		return "/myPage/review";
		
	}
	
	@GetMapping("myPage/coupon")
	private String coupon() {
		
		return "/myPage/coupon";
		
	}
}
