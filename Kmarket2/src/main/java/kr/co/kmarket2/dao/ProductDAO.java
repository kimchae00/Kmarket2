package kr.co.kmarket2.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.CartVO;
import kr.co.kmarket2.vo.OrderItemVO;
import kr.co.kmarket2.vo.OrderVO;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;
import kr.co.kmarket2.vo.ReviewVO;

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
	public ProductVO selectProduct(String prodNo);
	
	// review
	public List<ReviewVO> selectReview(String prodNo, int start);
	public int selectCountTotalReview(String prodNo);
	
	
	// cart
	public int insertCart(CartVO vo);
	public List<CartVO> selectCart(String uid);
	public int deleteCartByCartNo(@Param("cartNo") int cartNo);
	public int deleteCartByProdNo(List<String> prodNo);
	
	// order
	public List<CartVO> selectCartByCartNo(List<String> cartNo);
	public int insertOrder(OrderVO order);
	public int insertOrderItem(OrderItemVO item);
	public CartVO selectCartByProdNo(String prodNo, String uid);
	public OrderVO selectOrderByUid(String uid);
	 public OrderVO selectOrder(int ordNo);
	 
	// search
	public List<ProductVO> searchProduct(String keyword);
	public int searchProductTotal(String keyword);
}
