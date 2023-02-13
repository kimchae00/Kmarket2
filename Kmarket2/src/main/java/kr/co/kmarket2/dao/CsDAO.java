package kr.co.kmarket2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ArticleVO;

@Mapper
@Repository
public interface CsDAO {

	public int insertArticle();
	
	public int selectArticle();
	
	public ArticleVO selectArticles(String cate1, String cate2);
	
	public int updateArticle();
	
	public int deleteArticle();
}
