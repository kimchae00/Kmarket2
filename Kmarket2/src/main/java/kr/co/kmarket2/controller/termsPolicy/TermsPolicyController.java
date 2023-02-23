package kr.co.kmarket2.controller.termsPolicy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket2.service.TermsPolicyService;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.TermsBuyerVO;
import kr.co.kmarket2.vo.TermsFinanceVO;
import kr.co.kmarket2.vo.TermsLocationVO;
import kr.co.kmarket2.vo.TermsPrivacyVO;
import kr.co.kmarket2.vo.TermsSellerVO;

@Controller
public class TermsPolicyController {

	@Autowired
	private TermsPolicyService service;
	
	@GetMapping("termsPolicy/buyer")
	public String buyer(Model model, String prodCate1, String prodCate2) {
		// 카테고리 출력
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		model.addAttribute("prodCate1", prodCate1);
		model.addAttribute("prodCate2", prodCate2);
		
		List<TermsBuyerVO> buyers = service.selectTermsBuyer();
		model.addAttribute("buyers", buyers);
		
		return "termsPolicy/buyer";
	}
	
	@GetMapping("termsPolicy/finance")
	public String finance(Model model, String prodCate1, String prodCate2) {
		// 카테고리 출력
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		model.addAttribute("prodCate1", prodCate1);
		model.addAttribute("prodCate2", prodCate2);
		
		List<TermsFinanceVO> finances = service.selectTermsFinance();
		model.addAttribute("finances",finances);
		
		return "termsPolicy/finance";
	}
	
	@GetMapping("termsPolicy/location")
	public String location(Model model, String prodCate1, String prodCate2) {
		// 카테고리 출력
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		model.addAttribute("prodCate1", prodCate1);
		model.addAttribute("prodCate2", prodCate2);
		
		List<TermsLocationVO> locations = service.selectTermsLocation();
		model.addAttribute("locations", locations);
		
		
		return "termsPolicy/location";
	}
	
	
	@GetMapping("termsPolicy/privacy")
	public String privacy(Model model, String prodCate1, String prodCate2) {
		// 카테고리 출력
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		model.addAttribute("prodCate1", prodCate1);
		model.addAttribute("prodCate2", prodCate2);
		
		List<TermsPrivacyVO> ps = service.selectTermsPrivacy();
		model.addAttribute("ps", ps);
		
		
		return "termsPolicy/privacy";
	}
	
	@GetMapping("termsPolicy/seller")
	public String seller(Model model, String prodCate1, String prodCate2) {
		// 카테고리 출력
		List<ProdCate1VO> cate1s = service.selectCate1();
		List<ProdCate2VO> cate2s = service.selectCate2();
		model.addAttribute("cate1s", cate1s);
		model.addAttribute("cate2s", cate2s);
		model.addAttribute("prodCate1", prodCate1);
		model.addAttribute("prodCate2", prodCate2);
		
		List<TermsSellerVO> ss = service.selectTermsSeller();
		model.addAttribute("ss", ss);
		
		return "termsPolicy/seller";
	}
	
	
}
