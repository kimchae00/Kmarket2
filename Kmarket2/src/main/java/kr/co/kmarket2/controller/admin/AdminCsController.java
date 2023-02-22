package kr.co.kmarket2.controller.admin;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import kr.co.kmarket2.service.AdminCsService;
import kr.co.kmarket2.vo.ArticleVO;

@Controller
public class AdminCsController {
	
	@Autowired
	private AdminCsService service;
	
	@GetMapping("/admin/cs/notice/list")
	public String noticelist(Model model, String cate, String pg) {
		
		return "/admin/cs/notice/list";
	}
	
	@GetMapping("/admin/cs/notice/view")
	public String noticeview(Model model, int no, String group, String cate) {
		
		ArticleVO notice = service.selectArticle(no);
		
		model.addAttribute("notice", notice);
		model.addAttribute("cate", cate);
		
		return "/admin/cs/notice/view";
	}
	
	@GetMapping("/admin/cs/notice/write")
	public String noticewrite() {
		return "/admin/cs/notice/write";
	}
	
	@PostMapping("/admin/cs/notice/write")
	@ResponseBody
	public Map<String, Integer> noticewrite(Principal principal, @RequestParam("cate") String cate, @RequestParam("title") String title, @RequestParam("content") String content) {
		String uid = principal.getName();
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String regip 	= req.getRemoteAddr();
		
		int result = service.insertNotice(uid, cate, title, content, regip);
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
	
	@GetMapping("/admin/cs/notice/modify")
	public String noticemodify(Model model, int no, String group, String cate) {
		
		ArticleVO article = service.selectArticle(no);
		
		model.addAttribute("article", article);
		model.addAttribute("cate", cate);
		
		return "/admin/cs/notice/modify";
	}
	
	@PostMapping("/admin/cs/notice/modify")
	@ResponseBody
	public Map<String, Integer> noticemodify(Principal principal, @RequestParam("cate") String cate, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("no") Integer no) {
		String uid = principal.getName();
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String regip 	= req.getRemoteAddr();
		
		int result = service.updateNotice(uid, cate, title, content, regip, no);
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
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
