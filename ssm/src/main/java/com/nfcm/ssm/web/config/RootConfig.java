package com.nfcm.ssm.web.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(basePackages={"com.nfcm"},excludeFilters={@Filter(type=FilterType.ANNOTATION,classes=EnableWebMvc.class)})
@Import(value={})
@PropertySource(value={"classpath:properties/db.properties"})
public class RootConfig {
	
	@Autowired
	Environment env;

	//配置国际化properties文件
//	@Bean
//	public MessageSource messageSource(){
//		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
//		resource.setBasename("mes");
//		return resource;
//	}
	/**
	 * dbcp数据源
	 * @return
	 */
	@Bean
	public DataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("mysql.driverClass"));
		ds.setUrl(env.getProperty("mysql.url"));
		ds.setUsername(env.getProperty("mysql.username"));
		ds.setPassword(env.getProperty("mysql.password"));
		ds.setInitialSize(5);
		ds.setMaxActive(10);
		return ds;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
		
	}
	
	

}
