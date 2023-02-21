package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ArticleVO;

@Mapper
@Repository
public interface CsDAO {

	public int insertArticle();
	
	public ArticleVO selectArticle(int no);
	
	/* 그룹(notice) */
	public List<ArticleVO> selectArticles(String group, int start);
	
	/* 카테고리(notice) */
	public List<ArticleVO> selectCates(String group, String cate, int start);
	
	/* index에 공지사항 5개만 미리보기 */
	public List<ArticleVO> selectIndexNotice();
	
	/* index에 qna 5개만 미리보기 */
	public List<ArticleVO> selectIndexQna();
	
	/* FAQ 각각의 카테고리 출력 */
	public List<ArticleVO> selectFaqCates(String cate);
	
	/* FAQ 각각의 카테고리별 리스트 출력 */
	public List<ArticleVO> selectFaqList(String group, String cate);
	
	/* QNA리스트 출력 */
	public List<ArticleVO> selectQnaList(String group, String cate, int start);
	
	/* QNA VIEW 출력 */
	public ArticleVO selectQna(int no);
	
	/* 답변 존재 여부 확인 */
	public int selectCountAnswer(int no);
	
	/* 답변 출력 */
	public ArticleVO selectAnswer(int no);
	
	public int updateArticle();
	
	public int deleteArticle();
	
	/* 페이징을 위해 그룹의 게시물 총 갯수(notice list의 전체) */
	public int selectCountTotal(String group);
	
	
	/* 페이징을 위해 카테고리의 게시물 총 갯수 */
	public int selectCountCateTotal(String group, String cate);
	
	/* 페이징을 위해 qna 카테고리의 게시물 총 갯수 */
	public int selectCountQna(String group, String cate);

	

	
}