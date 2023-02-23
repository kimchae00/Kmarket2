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
	@ResponseBody
	public String noticelist(Model model, @RequestParam(value="cate") String cate) {
		List<ArticleVO> notices = service.selectNoticeAll();
		model.addAttribute("notices", notices);
		
		List<ArticleVO> cates = service.selectNotices(cate);
		model.addAttribute("cates", cates);
		
		
		return "/admin/cs/notice/list";
	}

	@GetMapping("/admin/cs/notice/view")
	public String noticeview(Model model, int no, String group, String cate) {
		
		ArticleVO notice = service.selectNotice(no);
		
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
		
		ArticleVO article = service.selectNotice(no);
		
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
	
	/* faq view*/
	@GetMapping("/admin/cs/faq/view")
	public String faqview(Model model, int no, String cate, String cate2) {
		ArticleVO faq = service.selectArticle(no);
		model.addAttribute("faq",faq);
		
		return "/admin/cs/faq/view";
	}
	
	/* faq modify*/
	@GetMapping("/admin/cs/faq/modify")
	public String faqmodify(Model model, int no, String cate, String cate2) {
		ArticleVO modify = service.selectArticle(no);
		model.addAttribute("modify",modify);
		
		return "/admin/cs/faq/modify";
	}
	
	/* faq modify post*/
	@PostMapping("/admin/cs/faq/modify")
	@ResponseBody
	public Map<String, Integer> faqmodify(Principal principal, @RequestParam("cate") String cate, @RequestParam("c2Name") String c2Name, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("no") Integer no) {
		System.out.println("cate : " + cate);
		String uid = principal.getName();
		System.out.println("uid : " + uid);
		
		
		String cate2 = service.selectCate2(c2Name);
		System.out.println("cate2 : " + cate2);
		
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String regip 	= req.getRemoteAddr();
		
		int result = service.updateFaq(uid, cate, cate2, title, content, regip, no);
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
	
	/* qna 리스트 */
	@GetMapping("/admin/cs/qna/list")
	public String qnalist() {
		return "/admin/cs/qna/list";
	}
	
	/* qna view */
	@GetMapping("/admin/cs/qna/view")
	public String qnaview(Model model, int no, String cate, String cate2) {
		ArticleVO qna = service.selectArticle(no);
		int on = service.selectCountParent(no);
		if(on != 0) {
		int parent = no;
		ArticleVO response = service.selectResponse(parent);
		model.addAttribute("response", response);
		}
		
		model.addAttribute("qna", qna);
		
		model.addAttribute("cate", cate);
		model.addAttribute("cate2", cate2);
		return "/admin/cs/qna/view";
	}
	
	/* qna reply */
	@GetMapping("/admin/cs/qna/reply")
	public String qnareply(Model model, int no, String cate, String cate2) {
		ArticleVO qna = service.selectArticle(no);
		
		model.addAttribute("qna", qna);
		
		model.addAttribute("cate", cate);
		model.addAttribute("cate2", cate2);
		return "/admin/cs/qna/reply";
	}
	
	/* qna reply 답변 등록 */
	@PostMapping("/admin/cs/qna/reply")
	@ResponseBody
	public Map<String, Integer> qnawrite(Principal principal, @RequestParam("content") String content, @RequestParam("no") String no) {
		String uid = principal.getName();
		System.out.println("uid : " + uid);
		int num = Integer.parseInt(no);
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String regip 	= req.getRemoteAddr();
		
		int result = service.insertReply(uid, content, num, regip);
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
}
