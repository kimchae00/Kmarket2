package kr.co.kmarket2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.MyPageDAO;
import kr.co.kmarket2.dao.termsPolicyDAO;
import kr.co.kmarket2.vo.ArticleVO;
import kr.co.kmarket2.vo.MemberVO;
import kr.co.kmarket2.vo.TermsBuyerVO;
import kr.co.kmarket2.vo.TermsFinanceVO;
import kr.co.kmarket2.vo.TermsLocationVO;
import kr.co.kmarket2.vo.TermsPrivacyVO;
import kr.co.kmarket2.vo.TermsSellerVO;


@Service
public class MyPageService {
	
	@Autowired
	private MyPageDAO dao;
	
	public MemberVO selectUserInfo(String uid) {
		return dao.selectUserInfo(uid);
	}
	
	//문의하기
	public List<ArticleVO> selectQnaMore(String uid, int start) {
		return dao.selectQnaMore(uid, start);
	}
	
	public List<ArticleVO> selectQna(String uid) {
		return dao.selectQna(uid);
	}
	
	public int selectCountTotal(String uid) {
		return dao.selectCountTotal(uid);
	}
	

	// 현재 페이지 번호
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		
		return currentPage;
	}
	
	// 페이지 시작값
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	// 마지막 페이지 번호
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;			
		}else {
			lastPageNum = total / 10 + 1;
		}
		return lastPageNum;
	}
	
	// 페이지 시작 번호
		public int getPageStartNum(int total, int start) {
			return total - start;
		}
		
		// 페이지 그룹
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
