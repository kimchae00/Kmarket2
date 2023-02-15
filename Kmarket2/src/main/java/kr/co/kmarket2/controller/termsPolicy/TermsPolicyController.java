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
	private String buyer() {
		return "/termsPolicy/buyer";
		
	}
	
	@GetMapping("termsPolicy/finance")
	private String finance() {
		return "termsPolicy/finance";
	}
	
	@GetMapping("termsPolicy/location")
	private String location() {
		return "termsPolicy/location";
	}
	
	
	@GetMapping("termsPolicy/privacy")
	private String privacy() {
		return "termsPolicy/privacy";
	}
	
	@GetMapping("termsPolicy/seller")
	private String seller() {
		return "/termsPolicy/seller";
	}
	
	
}
