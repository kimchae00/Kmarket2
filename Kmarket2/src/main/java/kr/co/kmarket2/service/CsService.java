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
	public ArticleVO selectArticle(int no) {
		return dao.selectArticle(no);
	}
	
	public List<ArticleVO> selectArticles(String group, int start) {
		return dao.selectArticles(group, start);
	}
	
	public List<ArticleVO> selectCates(String group, String cate, int start) {
		return dao.selectCates(group, cate, start);
	}
	
	public List<ArticleVO> selectQnaList(String group, String cate, int start){
		return dao.selectQnaList(group, cate, start);
	}
	
	public void updateArticle() {
		
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