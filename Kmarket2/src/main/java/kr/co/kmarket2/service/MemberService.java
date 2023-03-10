package kr.co.kmarket2.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kmarket2.dao.MemberDAO;
import kr.co.kmarket2.entity.MemberEntity;
import kr.co.kmarket2.repository.MemberRepo;
import kr.co.kmarket2.vo.MemberTermsVO;
import kr.co.kmarket2.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private MemberRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public int insertUserNormal(MemberVO vo) {
		vo.setPass(passwordEncoder.encode(vo.getPass2()));
		int result = dao.insertUserNormal(vo);
		return result;
	}
	public int insertUserSeller(MemberVO vo) {
		vo.setPass(passwordEncoder.encode(vo.getPass2()));
		int result = dao.insertUserSeller(vo);
		return result;
	}
	public int countUid(String uid) {
		return repo.countByUid(uid);
	}
	public int countByNameAndEmail(String name, String email) {
		return repo.countByNameAndEmail(name, email);
	}
	public MemberVO findId(String name, String email) {
		return dao.findId(name, email);
	}
	public int findPw(String uid, String email) {
		return dao.findPw(uid, email);
	}
	public int findPwChange(String uid, String pass) {
		return dao.findPwChange(uid, pass);
	}
	public MemberTermsVO selectTerms() {
		return dao.selectTerms();
	}
	public void selectUser() {}
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}
	
	
}
