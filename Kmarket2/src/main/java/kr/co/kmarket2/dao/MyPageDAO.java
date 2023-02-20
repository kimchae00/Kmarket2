package kr.co.kmarket2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.TermsBuyerVO;
import kr.co.kmarket2.vo.TermsFinanceVO;
import kr.co.kmarket2.vo.TermsLocationVO;
import kr.co.kmarket2.vo.TermsPrivacyVO;
import kr.co.kmarket2.vo.TermsSellerVO;


@Mapper
@Repository
public interface MyPageDAO {

	public TermsBuyerVO selectTermsBuyer();
	
	public TermsSellerVO selectTermsSeller();
	 
	public TermsFinanceVO selectTermsFinance();
	
	public TermsLocationVO selectTermsLocation();
	
	public TermsPrivacyVO selectTermsPrivacy();
	
}
