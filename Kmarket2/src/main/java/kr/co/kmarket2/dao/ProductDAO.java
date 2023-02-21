package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.CartVO;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;

@Mapper
@Repository
public interface ProductDAO {
	
	// 카테고리 출력
	public List<ProdCate1VO> selectCate1();
	public List<ProdCate2VO> selectCate2();
	
	// list
	public int selectCountTotal(String prodCate1, String prodCate2);
	public List<ProductVO> selectProducts(int start, String prodCate1, String prodCate2);
	public List<ProductVO> selectProductsBySold(int start, String prodCate1, String prodCate2);
	public List<ProductVO> selectProductsByLowPrice(int start, String prodCate1, String prodCate2);
	public List<ProductVO> selectProductsByHighPrice(int start, String prodCate1, String prodCate2);
	public List<ProductVO> selectProductsByScore(int start, String prodCate1, String prodCate2);
	public List<ProductVO> selectProductsByReview(int start, String prodCate1, String prodCate2);
	public List<ProductVO> selectProductsByNew(int start, String prodCate1, String prodCate2);
	
	// view
	public ProductVO selectProduct(int prodNo);
	
	// cart
	public int insertCart(CartVO vo);

}
