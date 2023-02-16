package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;

@Mapper
@Repository
public interface AdminDAO {
	
	public List<ProdCate1VO> selectCate1();
	//public List<ProdCate2VO> selectCate2(String cate1);
	public int insertProduct(ProductVO vo);
	
}
