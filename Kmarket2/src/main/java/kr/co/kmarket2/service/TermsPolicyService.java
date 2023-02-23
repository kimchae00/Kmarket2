package kr.co.kmarket2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.TermsPolicyDAO;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.TermsBuyerVO;
import kr.co.kmarket2.vo.TermsFinanceVO;
import kr.co.kmarket2.vo.TermsLocationVO;
import kr.co.kmarket2.vo.TermsPrivacyVO;
import kr.co.kmarket2.vo.TermsSellerVO;


@Service
public class TermsPolicyService {
	
	@Autowired
	private TermsPolicyDAO dao;
	
	public List<ProdCate1VO> selectCate1(){
		return dao.selectCate1();
	}
	public List<ProdCate2VO> selectCate2(){
		return dao.selectCate2();
	}
	
	public List<TermsBuyerVO> selectTermsBuyer() {
		return dao.selectTermsBuyer();
	}
	
	public List<TermsSellerVO> selectTermsSeller() {
		return dao.selectTermsSeller();
	}
	
	public List<TermsFinanceVO> selectTermsFinance() {
		return dao.selectTermsFinance();
	}
	
	public List<TermsLocationVO> selectTermsLocation() {
		return dao.selectTermsLocation();
	}
	
	public List<TermsPrivacyVO> selectTermsPrivacy() {
		return dao.selectTermsPrivacy();
	}
	
	

}
