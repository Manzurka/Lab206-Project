package com.lab206;

import java.io.IOException;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class Lab206Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab206Application.class, args);
	}
	
//	@Bean
//	public MultipartConfigElement multipartConfigElement() {
//	    MultipartConfigFactory factory = new MultipartConfigFactory();
//	    factory.setMaxFileSize("500MB");
//	    factory.setMaxRequestSize("500MB");
//	    return factory.createMultipartConfig();
//	}
//    
//	@Bean
//	public CommonsMultipartResolver multipartResolver() throws IOException{
//	    CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//	    commonsMultipartResolver.setMaxUploadSize(10000000);
//	    return commonsMultipartResolver;
//	}
}
