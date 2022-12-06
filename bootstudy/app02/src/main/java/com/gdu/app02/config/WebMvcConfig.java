package com.gdu.app02.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	// implements의 특징 (인터페이스 구현체의 특징)
	// ctrl + space를 누르면 구현가능 목록이 뜬다.
	
	// 리소스 핸들러
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry : 각종 환경 저장
		registry.addResourceHandler("/load/image/**")
			.addResourceLocations("file:///C:/summernoteImage/");
	}
}
