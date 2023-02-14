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
	
	/* 그룹 */
	public List<ArticleVO> selectArticles(String group, int start);
	
	/* 카테고리 */
	public List<ArticleVO> selectCates(String group, String cate, int start);
	
	public int updateArticle();
	
	public int deleteArticle();
	
	/* 페이징을 위해 그룹의 게시물 총 갯수 */
	public int selectCountTotal(String group);
	
	/* 페이징을 위해 카테고리의 게시물 총 갯수 */
	public int selectCountCateTotal(String group, String cate);
}
