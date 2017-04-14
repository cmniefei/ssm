package com.nfcm.ssm.web.config;

import java.io.FileNotFoundException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageHelper;

@Configuration
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class MybatisConfig {

	/**
	 * 配置事务管理器
	 * @param dataSource
	 * @return
	 */
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource){
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		return transactionManager;
	}
	
	
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
		
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sessionTemplate;
	}
	
	/**
	 * 配置自动扫描
	 * @return
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		//设置mapper接口的包路径
		configurer.setBasePackage("com.nfcm.**.dao");
		return configurer;
		
	}
	
	/**
	 * 配置mybatis工厂
	 * @param dataSource
	 * @return
	 * @throws FileNotFoundException
	 */
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws FileNotFoundException{
		SqlSessionFactoryBean factoryBean =  new SqlSessionFactoryBean();
		//设置mybatis分页插件
		Interceptor pageHelper = new PageHelper();
		
		Properties props = new Properties();  
        props.setProperty("reasonable", "true");  
        props.setProperty("supportMethodsArguments", "true");  
        props.setProperty("returnPageInfo", "check");  
        props.setProperty("params", "count=countSql");  
        pageHelper.setProperties(props); 
		Interceptor interceptor[] ={pageHelper};
		
		factoryBean.setPlugins(interceptor);
		
		//设置公共配置
		Resource configLocation = new ClassPathResource("mybatis/SqlMapConfig.xml"); 
		factoryBean.setConfigLocation(configLocation);	
		//factoryBean.setTypeAliasesPackage("com.nfcm.**.pojo");//设置类的别名基础包路径
		//设置mapper文件的位置
		//添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setDataSource(dataSource);
        try {
        	//设置mapperxml的地址路径
			factoryBean.setMapperLocations(resolver.getResources("classpath:com/nfcm/**/mapper/*.xml"));
			return  factoryBean.getObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
