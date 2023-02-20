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
	
	public List<ProdCate2VO> selectCate2(int cate1){
		return dao.selectCate2(cate1);
	}
	
	
	public int insertProduct(ProductVO vo) {
		int result = 0;
		// 썸네일 이미지 경로 지정
		List<String> newFiles = thumbUpload(vo);
		vo.setThumb1("/Kmarket2/thumb/"+newFiles.get(0));
		vo.setThumb2("/Kmarket2/thumb/"+newFiles.get(1));
		vo.setThumb3("/Kmarket2/thumb/"+newFiles.get(2));
		vo.setDetail("/Kmarket2/thumb/"+newFiles.get(3));
		
		if(vo.getThumb1() != null) {
			result = dao.insertProduct(vo);
		}
		return result;
	}
	
	// 썸네일 이미지
	@Value("${spring.servlet.multipart.location}")
    private String uploadPath;
	
	public List<String> thumbUpload(ProductVO vo) {
		MultipartFile[] thumbs = {vo.getFilethumb1(),vo.getFilethumb2(),vo.getFilethumb3(),vo.getFiledetail()};
        List<String> newFiles = new ArrayList<>();

        	for(MultipartFile img : thumbs) {
        		if(!img.isEmpty()) {
        			String path = new File(uploadPath).getAbsolutePath();
                    
                    // 새 파일명 생성
                	String oName = img.getOriginalFilename();
                	int idx = oName.lastIndexOf(".");
                    String ext = oName.substring(idx); // 확장자
                    String nName = UUID.randomUUID().toString()+ext;
                    
                    try {
                    	img.transferTo(new File(path, nName));
                    	newFiles.add(nName);
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                    	e.printStackTrace();
        			}
        		}
            }
        
        
        return newFiles;
    }
	
}
