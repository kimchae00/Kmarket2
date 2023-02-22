package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;

@Mapper
@Repository
public interface MainDAO {

	// 카테고리 출력
	public List<ProdCate1VO> selectCate1();
	public List<ProdCate2VO> selectCate2();
	
	public List<ProductVO> selectProductsSold();
	public List<ProductVO> selectProductsHit();
	public List<ProductVO> selectProductsScore();
	public List<ProductVO> selectProductsNew();
	public List<ProductVO> selectProductsDiscount();
	
	// search
	public List<ProductVO> searchProduct(String search);
	public int searchProductTotal(String search);
}
