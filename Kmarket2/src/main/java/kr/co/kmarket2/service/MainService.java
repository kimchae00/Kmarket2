package kr.co.kmarket2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.MainDAO;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;

@Service
public class MainService {
	
	@Autowired
	private MainDAO dao;
	
	public List<ProdCate1VO> selectCate1(){
		return dao.selectCate1();
	}
	public List<ProdCate2VO> selectCate2(){
		return dao.selectCate2();
	}

	public List<ProductVO> selectProductsSold(){
		return dao.selectProductsSold();
	}
	public List<ProductVO> selectProductsHit(){
		return dao.selectProductsHit();
	}
	public List<ProductVO> selectProductsScore(){
		return dao.selectProductsScore();
	}
	public List<ProductVO> selectProductsNew(){
		return dao.selectProductsNew();
	}
	public List<ProductVO> selectProductsDiscount(){
		return dao.selectProductsDiscount();
	}
	
	// search
	public List<ProductVO> searchProduct(String search){
		return dao.searchProduct(search);
	}
	public int searchProductTotal(String search) {
		return dao.searchProductTotal(search);
	}
	
}
