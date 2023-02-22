package kr.co.kmarket2.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.kmarket2.service.AdminCsService;
import kr.co.kmarket2.vo.ArticleVO;

@Controller
public class AdminCsController {
	
	@Autowired
	private AdminCsService service;
	
	@GetMapping("/admin/cs/notice/list")
	public String noticelist(Model model, String cate) {
		
		List<ArticleVO> notices = service.selectNotices(cate);
		
		return "/admin/cs/notice/list";
	}
	
	
	/* faq 리스트 */
	@GetMapping("/admin/cs/faq/list")
	public String faqlist() {
		return "/admin/cs/faq/list";
	}
	
	/* qna 리스트 */
	@GetMapping("/admin/cs/qna/list")
	public String qnalist() {
		return "/admin/cs/qna/list";
	}
}
