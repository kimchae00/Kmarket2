package kr.co.kmarket2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.termsPolicyDAO;
import kr.co.kmarket2.vo.TermsBuyerVO;
import kr.co.kmarket2.vo.TermsFinanceVO;
import kr.co.kmarket2.vo.TermsLocationVO;
import kr.co.kmarket2.vo.TermsPrivacyVO;
import kr.co.kmarket2.vo.TermsSellerVO;


@Service
public class termsPolicyService {
	
	@Autowired
	private termsPolicyDAO dao;
	
	public TermsBuyerVO selectTermsBuyer() {
		return dao.selectTermsBuyer();
	}
	
	public TermsSellerVO selectTermsSeller() {
		return dao.selectTermsSeller();
	}
	
	public TermsFinanceVO selectTermsFinance() {
		return dao.selectTermsFinance();
	}
	
	public TermsLocationVO selectTermsLocation() {
		return dao.selectTermsLocation();
	}
	
	public TermsPrivacyVO selectTermsPrivacy() {
		return dao.selectTermsPrivacy();
	}
	
	

}
