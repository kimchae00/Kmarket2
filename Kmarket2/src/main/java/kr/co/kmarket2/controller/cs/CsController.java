package kr.co.kmarket2.controller.cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket2.service.CsService;
import kr.co.kmarket2.vo.ArticleVO;

@Controller
public class CsController {
	
	@Autowired
	public CsService service;
	
	@GetMapping(value= {"/cs", "/cs/index"})
	public String index() {
		return "cs/index";
	}
	
	@GetMapping("/cs/faq/list")
	public String faqlist() {
		return "cs/faq/list";
	}
	
	@GetMapping("/cs/faq/view")
	public String faqview(Model model, int no, String group, String cate) {
		
		ArticleVO article = service.selectArticle(no);
		return "cs/faq/view";
	}
	
	@GetMapping("/cs/notice/list")
	public String noticelist() {
		return "cs/notice/list";
	}
	
	@GetMapping("/cs/notice/view")
	public String noticeview() {
		return "cs/notice/view";
	}
	
	@GetMapping("/cs/qna/list")
	public String qnalist() {
		return "cs/qna/list";
	}
	
	@GetMapping("/cs/qna/view")
	public String qnaview() {
		return "cs/qna/view";
	}
	
	@GetMapping("/cs/qna/write")
	public String qnawrite() {
		return "cs/qna/write";
	}
}
