package kr.co.kmarket2.service;

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
		return dao.selectArticle();
	}
	
	public ArticleVO selectArticles(String cate1, String cate2) {
		return dao.selectArticles(cate1, cate2);
	}
	
	public void updateArticle() {
		
	}
	
	public void deleteArticle() {
		
	}
}
