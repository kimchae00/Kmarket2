package kr.co.kmarket2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.MemberTermsVO;
import kr.co.kmarket2.vo.MemberVO;

@Mapper
@Repository
public interface MemberDAO {
	
	public int insertUserNormal(MemberVO vo);
	public int insertUserSeller(MemberVO vo);
	public int countUid(String uid);
	public MemberTermsVO selectTerms();
	public void selectUser();
	public void selectUsers();
	public void updateUser();
	public void deleteUser();

}
