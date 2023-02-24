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
	
	public int insertReply(String uid, String content, int num, String regip) {
		return dao.insertReply(uid, content, num, regip);
	}
	
	public int insertNotice(String uid, String cate, String title, String content, String regip) {
		return dao.insertNotice(uid, cate, title, content, regip);
	}
	
	public int insertFaq(String uid, String cate, String cate2, String title, String content, String regip) {
		return dao.insertFaq(uid, cate, cate2, title, content, regip);
	}
	
	public String selectCate2(String c2Name) {
		return dao.selectCate2(c2Name);
	}
	
	public int selectCountParent(int no) {
		return dao.selectCountParent(no);
	}
	
	public ArticleVO selectArticle(int no) {
		return dao.selectArticle(no);
	}
	
	public ArticleVO selectResponse(int parent) {
		return dao.selectResponse(parent);
	}
	
	public int selectCountNoticeAll() {
		return dao.selectCountNoticeAll();
	}
	
	public List<ArticleVO> selectNoticeAll(String group, int start) {
		return dao.selectNoticeAll(group, start);
	}
	
	public List<ArticleVO> selectFaqQna(String group, int start){
		return dao.selectFaqQna(group, start);
	}
	
	public int selectCountNotice(String cate) {
		return dao.selectCountNotice(cate);
	}
	
	public ArticleVO selectNotice(int no) {
		return dao.selectNotice(no);
	}
	
	public List<ArticleVO> selectNotices(String cate) {
		return dao.selectNotices(cate);
	}
	
	public int updateNotice(String uid, String cate, String title, String content, String regip, int no) {
		return dao.updateNotice(uid, cate, title, content, regip, no);
	}
	
	public int updateFaq(String uid, String cate, String cate2,String title, String content, String regip, int no) {
		return dao.updateFaq(uid, cate, cate2,title, content, regip, no);
	}
	
	public int updateQna(int num) {
		return dao.updateQna(num);
	}
	
	
	/* 페이징을 위해 그룹의 게시물 총 갯수 */
	public int selectCountTotal(String group) {
		return dao.selectCountTotal(group);
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
