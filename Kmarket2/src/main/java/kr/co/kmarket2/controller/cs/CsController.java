package kr.co.kmarket2.controller.cs;

import java.util.List;

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
 public String noticeList(Model model,String group, String cate, String pg) {
    	
    	//페이징 
    	int currentPage = service.getCurrentPage(pg); // 현재 페이지 번호
		int total = 0;
		
		if(cate == null) {
				total = service.selectCountTotal(group); // 그룹 전체 게시물 갯수
		}else {
				total = service.selectCountCateTotal(group, cate); // 카테고리별 게시물 갯수
			}
		
		int lastPageNum = service.getLastPageNum(total);// 마지막 페이지 번호
		int[] result = service.getPageGroup(currentPage, lastPageNum); // 페이지 그룹 번호
		int pageStartNum = service.getPageStartNum(total, currentPage); // 페이지 시작 번호
		int start = service.getLimitStart(currentPage); // 시작 인덱스
		
		model.addAttribute("lastPageNum", lastPageNum);		
		model.addAttribute("currentPage", currentPage);		
		model.addAttribute("pageGroupStart", result[0]);
		model.addAttribute("pageGroupEnd", result[1]);
		model.addAttribute("pageStartNum", pageStartNum+1);
    			
		// 그룹 전체 글 가져오기
		List<ArticleVO> articles = service.selectArticles(group, start);
		
    	//카테고리별 글 가져오기
    	List<ArticleVO> article = service.selectCates(group ,cate ,start);
    	
    	model.addAttribute("cate",cate);
    	model.addAttribute("articles", articles);
    	model.addAttribute("article", article);
    	
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
