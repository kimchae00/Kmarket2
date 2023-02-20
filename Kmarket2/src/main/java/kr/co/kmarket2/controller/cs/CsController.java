package kr.co.kmarket2.controller.cs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket2.service.CsService;
import kr.co.kmarket2.vo.ArticleVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CsController {
	
	@Autowired
	public CsService service;
	
	@GetMapping(value= {"/cs", "/cs/index"})
	public String index(Model model) {
		List<ArticleVO> notices = service.selectIndexNotice();
		List<ArticleVO> qna = service.selectIndexQna();
		model.addAttribute("notices", notices);
		model.addAttribute("qna", qna);
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

 public String noticeList(Model model, String group, String cate, String pg) {
    	
    	//페이징 
    	int currentPage = service.getCurrentPage(pg); // 현재 페이지 번호
		int total = 0;
		
		if(cate == null) {
				total = service.selectCountTotal(group); // 그룹 전체 게시물 갯수
		}else {
				total = service.selectCountCateTotal(group, cate); // 카테고리별 게시물 갯수
		}
		log.info(String.valueOf(total));
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
		
		// 그룹 전체 글 가져오기
		List<ArticleVO> articles = service.selectArticles(group, start);
		
    	//카테고리별 글 가져오기
    	List<ArticleVO> categories = service.selectCates(group, cate, start);
    	
    	model.addAttribute("articles", articles);
    	model.addAttribute("categories", categories);
    	
    	log.info("articles : " + articles.toString());
    	log.info("categories : " + categories.toString());
		return "cs/notice/list";
	}
	
	@GetMapping("/cs/notice/view")
	public String noticeview(Model model, int no) {
		
		ArticleVO article = service.selectArticle(no);
		
		model.addAttribute("article", article);
		return "cs/notice/view";
	}
	
	@GetMapping("/cs/qna/list")
	public String qnalist(Model model, String group, String cate, String pg) {

    	//페이징 
    	int currentPage = service.getCurrentPage(pg); // 현재 페이지 번호
		int total = service.selectCountQna(group, cate); // qna 카테고리별 리스트 게시물 갯수
		
		log.info(String.valueOf(total));
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
		
    	//카테고리별 글 가져오기
    	List<ArticleVO> qnas = service.selectQnaList(group, cate, start);
    	

    	model.addAttribute("qnas", qnas);
    	
    	log.info("qnas : " + qnas.toString());
		return "cs/qna/list";
	}
	
	@GetMapping("/cs/qna/view")
	public String qnaview(Model model, int no, String cate) {
		
		// 본문
		ArticleVO qna = service.selectQna(no);
		int countAnswer = service.selectCountAnswer(no);
		log.info("countAnswer : "+countAnswer);
		// 답변
		if(countAnswer != 0) {
			ArticleVO answer = service.selectAnswer(no);
			model.addAttribute("answer", answer);
		}
		
		model.addAttribute("qna", qna);
		model.addAttribute("cate", cate);
		
		return "cs/qna/view";
	}
	
	@GetMapping("/cs/qna/write")
	public String qnawrite() {
		return "cs/qna/write";
	}
	
	@ResponseBody
	@PostMapping("/cs/write")
	public void write() {
		
		System.out.println("1");
	}
}