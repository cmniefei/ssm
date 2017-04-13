package com.nfcm.ssm.web.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nfcm.ssm.web.config.RootConfig;
import com.nfcm.ssm.web.config.WebConfig;


public class SsmWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * 设置整体spring配置
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{RootConfig.class};
	}
	/**
	 * 设置springmvc的配置	
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		/*在Servlet 3.0环境中，容器会在类路径中
		查找实现javax.servlet.ServletContainerInitializer接口的类，如果能发现的
		话，就会用它来配置Servlet容器。
		Spring提供了这个接口的实现，名为SpringServletContainerInitializer，这个类
		反过来又会查找实现WebApplicationInitializer的类并将配置的任务交给它们来完
		成。Spring 3.2引入了一个便利的WebApplicationInitializer基础实现，也就
		是AbstractAnnotationConfigDispatcherServletInitializer*/
		return new String[]{"/"};
	}
	

}
