package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ArticleVO;

@Mapper
@Repository
public interface AdminCsDAO {
	
	// 답변 쓰기
	public int insertReply(String uid, String content, int num, String regip);
	
	// c2Name cate2로 변환
	public String selectCate2(String c2Name);
	
	// parent 존재 여부 확인
	public int selectCountParent(int no);
	
	// notice 공지 쓰기
	public int insertNotice(String uid, String cate, String title, String content, String regip);
	
	// 글 보기
	public ArticleVO selectArticle(int no);
	
	// notice 글보기
	public ArticleVO selectNotice(int no);
	
	// notice 답변 보기
	public ArticleVO selectResponse(int parent);
	
	// notice 전체 게시글 갯수
	public int selectCountNoticeAll();
	
	// notice 전체 들고오기
	public List<ArticleVO> selectNoticeAll(String group, int start);
	
	// faq, qna 전체 들고오기
	public List<ArticleVO> selectFaqQna(String group, int start);
	
	// notice 카테별 게시글 갯수
	public int selectCountNotice(String cate);
	
	// notice 카테별로 리스트 들고오기
	public List<ArticleVO> selectNotices(String cate);
	
	// notice 공지 수정
	public int updateNotice(String uid, String cate, String title, String content, String regip, int no);
	
	// faq 수정
	public int updateFaq(String uid, String cate, String cate2, String title, String content, String regip, int no);
	
	// paging용 전체 갯수
	public int selectCountTotal(String group);
}

