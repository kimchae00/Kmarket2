package kr.co.kmarket2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.AdminCsDAO;
import kr.co.kmarket2.vo.ArticleVO;

@Service
public class AdminCsService {

	@Autowired
	private AdminCsDAO dao;
	
	public int insertNotice(String uid, String cate, String title, String content, String regip) {
		return dao.insertNotice(uid, cate, title, content, regip);
	}
	
	public ArticleVO selectArticle(int no) {
		return dao.selectArticle(no);
	}
	
	public int selectCountNoticeAll() {
		return dao.selectCountNoticeAll();
	}
	
	public List<ArticleVO> selectNoticeAll() {
		return dao.selectNoticeAll();
	}
	
	public int selectCountNotice(String cate) {
		return dao.selectCountNotice(cate);
	}
	
	public List<ArticleVO> selectNotices(String cate) {
		return dao.selectNotices(cate);
	}
	
	public int updateNotice(String uid, String cate, String title, String content, String regip, int no) {
		return dao.updateNotice(uid, cate, title, content, regip, no);
	}
	
	
	/**/
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
