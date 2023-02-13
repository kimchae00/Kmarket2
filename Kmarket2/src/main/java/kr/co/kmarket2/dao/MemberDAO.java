package kr.co.kmarket2.dao;

import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.MemberTermsVO;

@Repository
public interface MemberDAO {
	
	public void insertUser();
	public MemberTermsVO selectTerms();
	public void selectUser();
	public void selectUsers();
	public void updateUser();
	public void deleteUser();

}
