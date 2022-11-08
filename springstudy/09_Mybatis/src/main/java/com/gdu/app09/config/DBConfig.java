package com.gdu.app09.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/* 
 	@PropertySource
 	안녕. 난 프로퍼티 파일을 참조할 수 있는 에너테이션이야.
 		// 프로퍼티 파일 참조 방식 3가지 : 자바코드로 입력, 애너테이션으로 읽기
 */
@PropertySource(value = {"classpath:mybatis/config/db.properties"})
					// src/main/resources /mybatis 경로

@EnableTransactionManagement
@EnableAspectJAutoProxy
@Configuration
public class DBConfig {
	
	// hikaricp에서 사용
	/*
	@Bean
	public DriverManagerDataSource dataSource() {
		//* jdbc기반의 데이터소스
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("SCOTT");
		dataSource.setPassword("TIGER");
		return dataSource;
	}
	*/
	// db.properties 파일을 읽어서 변수에 저장하기
	// ${프로퍼티명}
	@Value (value = "${hikari.driver}")
	private String driver;
	@Value (value = "${hikari.url}")
	private String url;
	@Value (value = "${hikari.username}")
	private String username;
	@Value (value = "${hikari.password}")
	private String password;
	
	// HikariConfig
	//* 환경설정
	@Bean
	public HikariConfig config() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driver);
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		return config;		
	}
	
	// HikariDataSource
	@Bean(destroyMethod = "close")
	public HikariDataSource dataSource() {
		return new HikariDataSource(config());
	}
	
	// * 마이바티스 세팅 시작 --------------------------------------------------
	// SqlSessionFactory
	@Bean
	public SqlSessionFactory factory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mybatis/mapper/*.xml"));
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("mybatis/config/mybatis-config.xml"));
		return bean.getObject();
	}
	
	// SqlSessionTemplate  (*스프링에서 사용/ cf. 이클립스에서는 : SqlSession)
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(factory());
	}
	
	
	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
