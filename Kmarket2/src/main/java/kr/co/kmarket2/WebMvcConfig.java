package kr.co.kmarket2;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
	// 로컬이미지 출력하기 위한 방법
	// https://velog.io/@jakeseo_me/%EC%8A%A4%ED%94%84%EB%A7%81%EA%B3%BC-JPA-%EA%B8%B0%EB%B0%98-%EC%9B%B9-%EC%95%A0%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98-%EA%B0%9C%EB%B0%9C-59-%EC%8A%A4%ED%84%B0%EB%94%94-%EC%84%A4%EC%A0%95-%EB%B0%B0%EB%84%88-%ED%95%84%ED%84%B0%EC%99%80-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0%EC%9D%98-%EC%B0%A8%EC%9D%B4-%ED%95%84%ED%84%B0%EC%99%80-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0%EB%A1%9C-%EA%B6%8C%ED%95%9C-%EA%B4%80%EB%A6%AC-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%9D%98-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C-step-by-step%EC%9C%BC%EB%A1%9C-%EB%B0%B0%EC%9A%B0%EA%B8%B0
	// 위 링크 참고
	
	private final StorageProperties storage;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler(storage.getWebLocation() + "/**" )
        	.addResourceLocations("file:" + Paths.get("thumb").toAbsolutePath() + "/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}
