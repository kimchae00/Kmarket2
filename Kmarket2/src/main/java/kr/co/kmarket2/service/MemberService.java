package kr.co.kmarket2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.MemberDAO;
import kr.co.kmarket2.vo.MemberTermsVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;

	public void insertUser() {}
	public MemberTermsVO selectTerms() {
		return dao.selectTerms();
	}
	public void selectUser() {}
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}
	
	
}
