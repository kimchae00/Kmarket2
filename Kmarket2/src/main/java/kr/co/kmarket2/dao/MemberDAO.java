package kr.co.kmarket2.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kmarket2.entity.MemberEntity;
import kr.co.kmarket2.vo.MemberTermsVO;
import kr.co.kmarket2.vo.MemberVO;

@Mapper
@Repository
public interface MemberDAO {
	
	public int insertUserNormal(MemberVO vo);
	public int insertUserSeller(MemberVO vo);
	public int countByUid(String uid);
	public int countByNameAndEmail(String name, String email);
	public MemberVO findId(String name, String email);
	public int findPw(String uid, String email);
	public int findPwChange(String uid, String pass);
	public MemberTermsVO selectTerms();
	public void selectUser();
	public void selectUsers();
	public void updateUser();
	public void deleteUser();

}
