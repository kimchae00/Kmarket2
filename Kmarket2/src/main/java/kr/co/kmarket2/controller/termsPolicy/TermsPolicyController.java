package kr.co.kmarket2.controller.termsPolicy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket2.service.termsPolicyService;
import kr.co.kmarket2.vo.TermsBuyerVO;
import kr.co.kmarket2.vo.TermsFinanceVO;
import kr.co.kmarket2.vo.TermsLocationVO;
import kr.co.kmarket2.vo.TermsPrivacyVO;
import kr.co.kmarket2.vo.TermsSellerVO;

@Controller
public class TermsPolicyController {

	@Autowired
	private termsPolicyService service;
	
	@GetMapping("termsPolicy/buyer")
	private String buyer(Model model) {
		TermsBuyerVO vo = service.selectTermsBuyer();
		model.addAttribute("vo", vo);
		return "/termsPolicy/buyer";
		
	}
	
	@GetMapping("termsPolicy/finance")
	private String finance(Model model) {
		TermsFinanceVO vo = service.selectTermsFinance();
		model.addAttribute("vo", vo);
		return "termsPolicy/finance";
	}
	
	@GetMapping("termsPolicy/location")
	private String location(Model model) {
		TermsLocationVO vo = service.selectTermsLocation();
		model.addAttribute("vo", vo);
		return "termsPolicy/location";
	}
	
	
	@GetMapping("termsPolicy/privacy")
	private String privacy(Model model) {
		TermsPrivacyVO vo = service.selectTermsPrivacy();
		model.addAttribute("vo", vo);
		return "termsPolicy/privacy";
	}
	
	@GetMapping("termsPolicy/seller")
	private String seller(Model model) {
		TermsSellerVO vo = service.selectTermsSeller();
		model.addAttribute("vo", vo);
		
		return "/termsPolicy/seller";
	}
	
	
}
