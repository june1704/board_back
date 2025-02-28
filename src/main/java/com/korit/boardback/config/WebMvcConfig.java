package com.korit.boardback.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Configuration // Spring 설정 클래스임을 나타냄
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${user.dir}") // 현재 애플리케이션이 실행되는 디렉터리를 가져옴
    private String rootPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 클라이언트가 "/image/**" 경로로 요청하면, 실제 파일 시스템의 "rootPath/upload"에서 파일을 찾도록 설정
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:" + rootPath + "/upload") // 파일이 저장된 실제 경로 지정
                .resourceChain(true) // 리소스 체인을 활성화하여 캐싱 최적화
                .addResolver(new PathResourceResolver() { // 커스텀 리소스 리졸버 추가
                    @Override
                    protected Resource getResource(String resourcePath, Resource location) throws IOException {
                        // URL 인코딩된 파일명을 UTF-8로 디코딩하여 정상적인 파일 경로로 변환
                        resourcePath = URLDecoder.decode(resourcePath, StandardCharsets.UTF_8);
                        // 부모 클래스의 getResource 메서드를 호출하여 해당 경로의 리소스를 반환
                        return super.getResource(resourcePath, location);
                    }
                });
    }
}
