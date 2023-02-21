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
	public ProductVO selectProduct(int prodNo) {
		return dao.selectProduct(prodNo);
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
	
}
