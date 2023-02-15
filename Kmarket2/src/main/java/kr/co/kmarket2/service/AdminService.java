package kr.co.kmarket2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.AdminDAO;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO dao;
	
	
	public List<ProdCate1VO> selectCate1() {
		return dao.selectCate1();
	}
	/*
	public List<ProdCate2VO> selectCate2() {
		return dao.selectCate2();
	}
	*/
	
}
