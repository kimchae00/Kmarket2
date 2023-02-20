package kr.co.kmarket2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.AdminDAO;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO dao;
	
	
	public List<ProdCate1VO> selectCate1() {
		return dao.selectCate1();
	}
	/*
	public List<ProdCate2VO> selectCate2(String cate1){
		return dao.selectCate2(cate1);
	}
	*/
	
	public int insertProduct(ProductVO vo) {
		int result = dao.insertProduct(vo);
		return result;
	}
}
