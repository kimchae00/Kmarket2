package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.TermsBuyerVO;
import kr.co.kmarket2.vo.TermsFinanceVO;
import kr.co.kmarket2.vo.TermsLocationVO;
import kr.co.kmarket2.vo.TermsPrivacyVO;
import kr.co.kmarket2.vo.TermsSellerVO;


@Mapper
@Repository
public interface TermsPolicyDAO {
	
	// 카테고리 출력
	public List<ProdCate1VO> selectCate1();
	public List<ProdCate2VO> selectCate2();

	public List<TermsBuyerVO> selectTermsBuyer();
	
	public List<TermsSellerVO> selectTermsSeller();
	 
	public List<TermsFinanceVO> selectTermsFinance();
	
	public List<TermsLocationVO> selectTermsLocation();
	
	public List<TermsPrivacyVO> selectTermsPrivacy();
	
}
