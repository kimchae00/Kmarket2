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
	
	public List<ArticleVO> selectNotices(String cate) {
		return dao.selectNotices(cate);
	}
}
