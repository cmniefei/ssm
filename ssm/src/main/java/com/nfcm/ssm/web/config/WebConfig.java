package com.nfcm.ssm.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc //启动springmvc
@ComponentScan(basePackages = { "com.nfcm.**.controller" })//扫描所有的controller包下的类注入到spring中
public class WebConfig {
	
	/**
	 * 配置视图解析器
	 * 
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setExposeContextBeansAsAttributes(true);
		resolver.setOrder(1);
		return resolver;
	}
	

	/**
	 * 开启文件下载
	 * @return
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		return resolver;
	}


}
