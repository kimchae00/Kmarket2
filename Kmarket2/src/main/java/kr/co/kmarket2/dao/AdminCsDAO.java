package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ArticleVO;

@Mapper
@Repository
public interface AdminCsDAO {
	
	// notice 공지 쓰기
	public int insertNotice(String uid, String cate, String title, String content, String regip);
	
	// notice 공지 보기
	public ArticleVO selectArticle(int no);
	
	// notice 전체 게시글 갯수
	public int selectCountNoticeAll();
	
	// notice 전체 들고오기
	public List<ArticleVO> selectNoticeAll();
	
	// notice 카테별 게시글 갯수
	public int selectCountNotice(String cate);
	
	// notice 카테별로 리스트 들고오기
	public List<ArticleVO> selectNotices(String cate);
	
	// notice 공지 수정
	public int updateNotice(String uid, String cate, String title, String content, String regip, int no);
}

