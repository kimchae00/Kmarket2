package kr.co.kmarket2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.TermsByuerVO;
import kr.co.kmarket2.vo.TermsFinanceVO;
import kr.co.kmarket2.vo.TermsLocationVO;
import kr.co.kmarket2.vo.TermsPrivacyVO;
import kr.co.kmarket2.vo.TermsSellerVO;


@Mapper
@Repository
public interface termsPolicyDAO {

	public TermsByuerVO selectTermsBuyer();
	
	public TermsSellerVO selectTermsSeller();
	 
	public TermsFinanceVO selectTermsFinance();
	
	public TermsLocationVO selectTermsLocation();
	
	public TermsPrivacyVO selectTermsPrivacy();
	
}
