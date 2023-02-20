package kr.co.kmarket2.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket2.dao.AdminDAO;
import kr.co.kmarket2.vo.ProdCate1VO;
import kr.co.kmarket2.vo.ProdCate2VO;
import kr.co.kmarket2.vo.ProductVO;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO dao;
	
	
	public List<ProdCate1VO> selectCate1() {
		return dao.selectCate1();
	}
	/*
	public List<ProdCate2VO> selectCate2(String cate1){
		return dao.selectCate2(cate1);
	}
	*/
	
	public int insertProduct(ProductVO vo) {
		int result = dao.insertProduct(vo);
		
		 //List<String> thumbs = thumbUpload(vo);
		
		return result;
	}
	
	// 썸네일 이미지
	@Value("${spring.servlet.multipart.location}")
    private String uploadPath;
	
	public List<String> thumbUpload(ProductVO vo, MultipartFile file) {
        MultipartFile[] thumbs = {vo.getThumb1(),vo.getThumb2(),vo.getThumb3(),vo.getDetail()};
        
        List<String> saveFiles = new ArrayList<>();
        List<String> newFiles = new ArrayList<>();

        String path = new File(uploadPath).getAbsolutePath();
        
        // 새 파일명 생성
    	String oName = file.getOriginalFilename();
    	int idx = oName.lastIndexOf(".");
        String ext = oName.substring(idx); // 확장자
        String nName = UUID.randomUUID().toString()+ext;
        
        try {
        	//thumbs.transferTo(new File(path, nName));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } 
        return newFiles;
    }
	
}
