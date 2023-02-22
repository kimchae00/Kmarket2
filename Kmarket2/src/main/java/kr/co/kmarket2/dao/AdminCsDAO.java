package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ArticleVO;

@Mapper
@Repository
public interface AdminCsDAO {
	
	// notice 카테별로 리스트 들고오기
	public List<ArticleVO> selectNotices(String cate);
}

