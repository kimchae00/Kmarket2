package kr.co.kmarket2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.CsDAO;
import kr.co.kmarket2.vo.ArticleVO;

@Service
public class CsService {

	@Autowired
	private CsDAO dao;
	
	/*
	public int insertArticle() {
		
	}
	*/
	public String selectCate2(String c2Name) {
		return dao.selectCate2(c2Name);
	}
	
	public ArticleVO selectArticle(int no) {
		return dao.selectArticle(no);
	}
	
	public List<ArticleVO> selectArticles(String group, int start) {
		return dao.selectArticles(group, start);
	}
	
	public List<ArticleVO> selectCates(String group, String cate, int start) {
		return dao.selectCates(group, cate, start);
	}
	
	public List<ArticleVO> selectFaqList(String group, String cate){
		return dao.selectFaqList(group, cate);
	}
	
	public List<ArticleVO> selectFaqCates(String cate){
		return dao.selectFaqCates(cate);
	}
	
	public List<ArticleVO> selectIndexNotice(){
		return dao.selectIndexNotice();
	}
	
	public List<ArticleVO> selectIndexQna(){
		return dao.selectIndexQna();
	}
	
	public List<ArticleVO> selectQnaList(String group, String cate, int start){
		return dao.selectQnaList(group, cate, start);
	}
	
	public ArticleVO selectQna(int no) {
		return dao.selectQna(no);
	}
	
	public int selectCountAnswer(int no) {
		return dao.selectCountAnswer(no);
	}
	
	public ArticleVO selectAnswer(int no) {
		return dao.selectAnswer(no);
	}
	
	public int insertQna(String uid, String cate, String cate2, String title, String content, String regip) {
		
		
		System.out.println("here1 : " + uid);
		System.out.println("here2 : " + cate);
		System.out.println("here3 : " + cate2);
		System.out.println("here4 : " + title);
		System.out.println("here5 : " + content);
		
		return dao.insertQna(uid, cate, cate2, title, content, regip);
	}
	
	public void deleteArticle() {
		
	}
	
	/* 페이징을 위해 그룹의 게시물 총 갯수 */
	public int selectCountTotal(String group) {
		return dao.selectCountTotal(group);
	}
	
	/* 페이징을 위해 카테고리의 게시물 총 갯수 */
	public int selectCountCateTotal(String group, String cate) {
		return dao.selectCountCateTotal(group, cate);
	}
	
	/* 페이징을 위해 Qna 카테고리의 게시물 총 갯수 */
	public int selectCountQna(String group, String cate) {
		return dao.selectCountQna(group, cate);
	}
	
	/* 현재 페이지 번호 */
	public int getCurrentPage(String pg) {
		
		int currentPage = 1;
		
		if(pg != null) {
			currentPage= Integer.parseInt(pg);
		}
		
		return currentPage;
		
	}
	
	// 페이징
	/////////////////////////////////////////////////////////
	/* 페이지 시작값 */
    public int getLimitStart(int currentPage) {
    	
        return (currentPage - 1) * 10;
        
    }
    
    /* 마지막 페이지 번호 */
    public int getLastPageNum(int total) {
    	
    	int lastPageNum = 0;
    	
    	if(total % 10 == 0) {
    		lastPageNum = total / 10;
    	}else {
    		lastPageNum = total / 10 + 1;
    	}
    	
    	return lastPageNum;
    	
    }
    
    /* 페이지 시작 번호 */
    public int getPageStartNum(int total, int start) {
    	
    	return total - start;
    	
    }
    
    /* 페이지 그룹 */
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		int groupCurrent = (int) Math.ceil(currentPage / 10.0);
		int groupStart = (groupCurrent - 1) * 10 + 1;
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
		
			groupEnd = lastPageNum;
			
		}
		
		int[] groups = {groupStart, groupEnd};
		
		return groups;
	}
    
}