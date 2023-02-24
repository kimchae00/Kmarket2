package kr.co.kmarket2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.ProductDAO;
import kr.co.kmarket2.vo.CartVO;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;
import kr.co.kmarket2.vo.ReviewVO;

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
	
	// 상품 게시물 카운트
	public int selectCountTotal(String prodCate1, String prodCate2) {
		return dao.selectCountTotal(prodCate1, prodCate2);
	}
	
	// 상품정렬
	public List<ProductVO> selectProducts(int start, String prodCate1,String prodCate2){
		return dao.selectProducts(start, prodCate1,prodCate2);
	}
	public List<ProductVO> selectProductsBySold(int start, String prodCate1,String prodCate2){
		return dao.selectProductsBySold(start, prodCate1,prodCate2);
	}
	public List<ProductVO> selectProductsByLowPrice(int start, String prodCate1,String prodCate2){
		return dao.selectProductsByLowPrice(start, prodCate1,prodCate2);
	}
	public List<ProductVO> selectProductsByHighPrice(int start, String prodCate1,String prodCate2){
		return dao.selectProductsByHighPrice(start, prodCate1,prodCate2);
	}
	public List<ProductVO> selectProductsByScore(int start, String prodCate1,String prodCate2){
		return dao.selectProductsByScore(start, prodCate1,prodCate2);
	}
	public List<ProductVO> selectProductsByReview(int start, String prodCate1,String prodCate2){
		return dao.selectProductsByReview(start, prodCate1,prodCate2);
	}
	public List<ProductVO> selectProductsByNew(int start, String prodCate1,String prodCate2){
		return dao.selectProductsByNew(start, prodCate1,prodCate2);
	}
	
	// 상품 view
	public ProductVO selectProduct(String prodNo) {
		return dao.selectProduct(prodNo);
	}
	
	// review
	public List<ReviewVO> selectReview(String prodNo, int start){
		return dao.selectReview(prodNo, start);
	}
	public int selectCountTotalReview(String prodNo) {
		return dao.selectCountTotalReview(prodNo);
	}
	
	// 장바구니
	public int insertCart(CartVO vo) {
		int result = dao.insertCart(vo);
		return result;
	}
	public List<CartVO> selectCart(String uid){
		return dao.selectCart(uid);
	}
	public int deleteCart(List<String> chks) {
		return dao.deleteCart(chks);
	}
	
	// 주문
	public List<CartVO> selectCartByCartNo(List<String> cartNo){
		return dao.selectCartByCartNo(cartNo);
	}
	
	// 검색
	public List<ProductVO> searchProduct(String keyword){
		return dao.searchProduct(keyword);
	}
	
	public List<ProductVO> seatchProduct(String keyword){
		return dao.searchProductPriceD(keyword);
	}
	
	
	
	public int searchProductTotal(String keyword) {
		return dao.searchProductTotal(keyword);
	}
	
	
	
	
	
	
	/////// list 페이징 처리
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
	
	  int lastpageNum = 0;
	
	  if(total % 10 == 0) {
	      lastpageNum = total / 10;
	
	  }else {
	      lastpageNum = total / 10 + 1;
	  }
	  return lastpageNum;
	}
	
	// 페이지 시작 번호
	public int getpageStartNum(int total, int start) {
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
	
	/////// review 페이징 처리
	// 현재 페이지 번호
	public int getCurrentPage2(String pg) {
	  int currentPage = 1;
	
	  if(pg != null) {
	      currentPage = Integer.parseInt(pg);
	  }
	  return currentPage;
	}
	
	// 페이지 시작값
	public int getLimitStart2(int currentPage) {
	  return (currentPage - 1) * 5;
	}
	
	// 마지막 페이지 번호
	public int getLastPageNum2(int total) {
	
	  int lastpageNum = 0;
	
	  if(total % 10 == 0) {
	      lastpageNum = total / 5;
	
	  }else {
	      lastpageNum = total / 5 + 1;
	  }
	  return lastpageNum;
	}
	
	// 페이지 시작 번호
	public int getpageStartNum2(int total, int start) {
	  return total - start;
	}
	
	// 페이지 그룹
	public int[] getPageGroup2(int currentPage, int lastPageNum) {
	
	  int groupCurrent = (int) Math.ceil(currentPage / 5.0);
	  int groupStart = (groupCurrent - 1) * 5 + 1;
	  int groupEnd = groupCurrent * 5;
	
	  if(groupEnd > lastPageNum) {
	      groupEnd = lastPageNum;
	  }
	
	  int[] groups = {groupStart, groupEnd};
	
	  return groups;
	}
	
}
