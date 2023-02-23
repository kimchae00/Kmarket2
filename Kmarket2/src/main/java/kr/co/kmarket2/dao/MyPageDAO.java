package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ArticleVO;
import kr.co.kmarket2.vo.MemberVO;
import kr.co.kmarket2.vo.OrderVO;
import kr.co.kmarket2.vo.ReviewVO;


@Mapper
@Repository
public interface MyPageDAO {

	public MemberVO selectUserInfo(@Param("uid") String uid);
	
	//문의하기
	public List<ArticleVO> selectQnaMore(@Param("uid")String uid, int start);
	public List<ArticleVO> selectQna(@Param("uid")String uid);
	
	//문의하기 게시글수 조회
	public int selectCountTotal(String uid);
	
	//리뷰하기
	public List<ReviewVO> selectReviewMore(String uid, int start);
	public List<ReviewVO> selectReview(String uid);
	public int selectCountReview(String uid);
	
	//상품전체 내역
	public List<OrderVO> selectOrderMore(String ordUid);
}
