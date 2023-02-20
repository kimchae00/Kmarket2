package kr.co.kmarket2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.ProductDAO;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	public List<ProdCate1VO> selectCate1(){
		return dao.selectCate1();
	}
	public List<ProdCate2VO> selectCate2(){
		return dao.selectCate2();
	}
	
	public List<ProductVO> selectProducts(String prodCate1,String prodCate2){
		return dao.selectProducts(prodCate1,prodCate2);
	}
	
}
