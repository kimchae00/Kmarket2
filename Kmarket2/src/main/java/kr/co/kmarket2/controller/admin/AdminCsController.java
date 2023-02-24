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
	
	@GetMapping("admin/cs/notice/list")
	public String noticelist(Model model, String group, String cate, String pg) {
		
		//페이징 
    	int currentPage = service.getCurrentPage(pg); // 현재 페이지 번호
		int total = 0;
		
		total = service.selectCountTotal(group);
		int lastPageNum = service.getLastPageNum(total);// 마지막 페이지 번호
		int[] result = service.getPageGroup(currentPage, lastPageNum); // 페이지 그룹 번호
		int pageStartNum = service.getPageStartNum(total, currentPage); // 페이지 시작 번호
		int start = service.getLimitStart(currentPage); // 시작 인덱스
		// 페이징용
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		model.addAttribute("lastPageNum", lastPageNum);		
		model.addAttribute("currentPage", currentPage);		
		model.addAttribute("pageGroupStart", result[0]);
		model.addAttribute("pageGroupEnd", result[1]);
		model.addAttribute("pageStartNum", pageStartNum+1);
		model.addAttribute("groups", groups);
		model.addAttribute("cate", cate);
		
		List<ArticleVO> notices = service.selectNoticeAll(group, start);
		model.addAttribute("notices", notices);
		
		
		return "admin/cs/notice/list";
	}

	@GetMapping("admin/cs/notice/view")
	public String noticeview(Model model, int no, String group, String cate) {
		
		ArticleVO notice = service.selectNotice(no);
		
		model.addAttribute("notice", notice);
		model.addAttribute("cate", cate);
		
		return "admin/cs/notice/view";
	}
	
	@GetMapping("admin/cs/notice/write")
	public String noticewrite() {
		return "admin/cs/notice/write";
	}
	
	@PostMapping("admin/cs/notice/write")
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
	
	@GetMapping("admin/cs/notice/modify")
	public String noticemodify(Model model, int no, String group, String cate) {
		
		ArticleVO article = service.selectNotice(no);
		
		model.addAttribute("article", article);
		model.addAttribute("cate", cate);
		
		return "admin/cs/notice/modify";
	}
	
	@PostMapping("admin/cs/notice/modify")
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
	/*
	@PostMapping("admin/cs/notice/list/deleteNotice")
	@ResponseBody
	public Map<String, Integer> deleteNotice(@RequestParam("chks") List<Integer> chks, String no) {
		int num = Integer.parseInt(no);
		for(chk : chks) {
		   int result = service.delectNotice(no);
		}
		
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
	*/
	/* faq 리스트 */
	@GetMapping("admin/cs/faq/list")
	public String faqlist(Model model, String group, String cate, String cate2, String pg) {
		
		//페이징 
    	int currentPage = service.getCurrentPage(pg); // 현재 페이지 번호
		int total = 0;
		
		total = service.selectCountTotal(group);
		int lastPageNum = service.getLastPageNum(total);// 마지막 페이지 번호
		int[] result = service.getPageGroup(currentPage, lastPageNum); // 페이지 그룹 번호
		int pageStartNum = service.getPageStartNum(total, currentPage); // 페이지 시작 번호
		int start = service.getLimitStart(currentPage); // 시작 인덱스
		// 페이징용
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		model.addAttribute("lastPageNum", lastPageNum);		
		model.addAttribute("currentPage", currentPage);		
		model.addAttribute("pageGroupStart", result[0]);
		model.addAttribute("pageGroupEnd", result[1]);
		model.addAttribute("pageStartNum", pageStartNum+1);
		model.addAttribute("groups", groups);
		model.addAttribute("cate", cate);
		model.addAttribute("cate2", cate2);
		
		List<ArticleVO> faqs = service.selectFaqQna(group, start);
		model.addAttribute("faqs", faqs);
		
		
		return "admin/cs/faq/list";
	}
	
	/* faq view*/
	@GetMapping("admin/cs/faq/view")
	public String faqview(Model model, int no, String cate, String cate2) {
		ArticleVO faq = service.selectArticle(no);
		model.addAttribute("faq",faq);
		
		return "admin/cs/faq/view";
	}
	
	/* faq write*/
	@GetMapping("admin/cs/faq/write")
	public String faqwrite() {
		return "admin/cs/faq/write";
	}
	
	@PostMapping("admin/cs/faq/write")
	@ResponseBody
	public Map<String, Integer> qnawrite(Principal principal, @RequestParam("cate") String cate, @RequestParam("c2Name") String c2Name, @RequestParam("title") String title, @RequestParam("content") String content) {
		System.out.println("cate : " + cate);
		String uid = principal.getName();
		System.out.println("uid : " + uid);
		
		
		String cate2 = service.selectCate2(c2Name);
		System.out.println("cate2 : " + cate2);
		
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String regip 	= req.getRemoteAddr();
		
		int result = service.insertFaq(uid, cate, cate2, title, content, regip);
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
	
	
	
	
	/* faq modify*/
	@GetMapping("admin/cs/faq/modify")
	public String faqmodify(Model model, int no, String cate, String cate2) {
		ArticleVO modify = service.selectArticle(no);
		model.addAttribute("modify",modify);
		
		return "admin/cs/faq/modify";
	}
	
	/* faq modify post*/
	@PostMapping("admin/cs/faq/modify")
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
	@GetMapping("admin/cs/qna/list")
	public String qnalist(Model model, String group, String cate, String cate2, String pg) {
		
		//페이징 
    	int currentPage = service.getCurrentPage(pg); // 현재 페이지 번호
		int total = 0;
		
		total = service.selectCountTotal(group);
		int lastPageNum = service.getLastPageNum(total);// 마지막 페이지 번호
		int[] result = service.getPageGroup(currentPage, lastPageNum); // 페이지 그룹 번호
		int pageStartNum = service.getPageStartNum(total, currentPage); // 페이지 시작 번호
		int start = service.getLimitStart(currentPage); // 시작 인덱스
		// 페이징용
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		model.addAttribute("lastPageNum", lastPageNum);		
		model.addAttribute("currentPage", currentPage);		
		model.addAttribute("pageGroupStart", result[0]);
		model.addAttribute("pageGroupEnd", result[1]);
		model.addAttribute("pageStartNum", pageStartNum+1);
		model.addAttribute("groups", groups);
		model.addAttribute("cate", cate);
		model.addAttribute("cate2", cate2);
		
		List<ArticleVO> qnas = service.selectFaqQna(group, start);
		model.addAttribute("qnas", qnas);
		
		
		return "admin/cs/qna/list";
	}
	
	/* qna view */
	@GetMapping("admin/cs/qna/view")
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
		return "admin/cs/qna/view";
	}
	
	/* qna reply */
	@GetMapping("admin/cs/qna/reply")
	public String qnareply(Model model, int no, String cate, String cate2) {
		ArticleVO qna = service.selectArticle(no);
		
		model.addAttribute("qna", qna);
		model.addAttribute("cate", cate);
		model.addAttribute("cate2", cate2);
		return "admin/cs/qna/reply";
	}
	
	/* qna reply 답변 등록 */
	@PostMapping("admin/cs/qna/reply")
	@ResponseBody
	public Map<String, Integer> qnawrite(Principal principal, @RequestParam("content") String content, @RequestParam("no") String no) {
		String uid = principal.getName();
		System.out.println("uid : " + uid);
		int num = Integer.parseInt(no);
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String regip 	= req.getRemoteAddr();
		
		int result = service.insertReply(uid, content, num, regip);
		service.updateQna(num);
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
}
