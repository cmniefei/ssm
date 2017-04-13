package com.nfcm.ssm.web.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.FilterRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 
 * @author aa
 *
 */
public class FilterInit implements WebApplicationInitializer {

	//设置过滤器，解决乱码问题
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Dynamic dynamic =servletContext.addFilter("myfilter", CharacterEncodingFilter.class);
		dynamic.setInitParameter("encoding", "utf-8");
		
		dynamic.addMappingForUrlPatterns(null, false, "/*");
		
	}
	
}
