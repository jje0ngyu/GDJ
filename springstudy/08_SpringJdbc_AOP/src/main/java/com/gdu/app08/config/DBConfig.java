package com.gdu.app08.config;

import java.util.Collections;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;


/* --------------------------------------------------------------------------------------
	■ 트랜잭션 사용방법 요약 ■
	
		1. 애너테이션 2개 준비 (@EnableTransactionManagement, @EnableAspectJAutoProxy)
		
		2. dataSource() 메소드 준비
			- 
		3. TransactionManager 준비
		
		4. TransactionInterceptor 준비
		
		5. Advisor 사용
----------------------------------------------------------------------------------------- */

/* --------------------------------------------------------------------------
	@EnableAspectJAutoProxy      : Aspect를 자동으로 동작시키는 애너테이션
	@EnableTransactionManagement : 트랜잭션매니저를 허용하는 애너테이션
 ---------------------------------------------------------------------------- */
@EnableTransactionManagement
@EnableAspectJAutoProxy
@Configuration
public class DBConfig {
	
	// SpringJdbc 처리를 위한 DriverManagerDataSource와 JdbcTemplate을 Bean으로 등록한다.
	
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
	
	//* JdbcTemplate 관련 블로그 : https://bibi6666667.tistory.com/300
	@Bean
	public JdbcTemplate jdbcTemplate() {
	//* 스프링프레임워크가 jdbc를 위해 지원하는 템플릿
		return new JdbcTemplate(dataSource());
		// dataSource() 의존 관계 처리
		//* 위의 데이터소스를 불러온다.
	}
	
	
	
	//* 트랜잭션 관련 블로그 : https://gngsn.tistory.com/152
	// 트랜잭션 처리를 위한 TransactionManger를 Bean으로 등록한다.
	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
		/*
			■ 설명 ■
			
			DataSourceTransactionManager()
				
				▷ JDBC 및 MyBatis 등의 JDBC 기반 라이브러리로 데이터베이스에 접근하는 경우에 이용
				▷ 이 트랜잭션 매니저를 사용하려면 트랜잭션을 적용할 dataSource가 스프링의 빈으로 등록되어야 한다.
				▷ DB의 개수에 따라 트랜잭션매니저를 추가 등록한다. (DB가 1개일 경우, 필요한 트랜잭션 매니저는 1개)
				
		*/
	
	// 트랜잭션 인터셉터를 Bean으로 등록한다.
	//* 트랜잭션은 정상적인 흐름이 아니기 때문에 인터셉터가 필요하다.
	//* 오작동시 인터셉터를 통해 정상으로 되돌린다.(?)
	@Bean
	public TransactionInterceptor transactionInterceptor() {
		// 모든 Exception이 발생하면 Rollback을 수행하겠다.
		//* 아래 코드는 마음을 비우고 따라한다.
		RuleBasedTransactionAttribute attribute = new RuleBasedTransactionAttribute();
		attribute.setName("*");
		attribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class))); //* Exception 타입이면 롤백이 작동한다.
		
		MatchAlwaysTransactionAttributeSource source = new MatchAlwaysTransactionAttributeSource();
		source.setTransactionAttribute(attribute);
		return new TransactionInterceptor(transactionManager(), source);
	}
	
	// (TransactionInterceptor를 Advice로 등록하는) Advisor를 Bean으로 등록한다.
	@Bean
	public Advisor advisor() {
		// 언제 Advisor를 동작시킬 것인가?
		// 포인트컷(PointCut)을 결정해야 한다.
		
		// 포인트컷 표현식
		/*
			1.기본형식
				execution(리턴타입 패키지.클래스.메소드(매개변수))
				
			2. 의미
				1) 리턴타입
					(1) *
					(2) void
					(3) !void
				2) 매개변수
					(1) ..	: 모든 매개변수
					(2) *   : 1개의 모든 매개변수
		 
		 */
		AspectJExpressionPointcut pointCut = new AspectJExpressionPointcut();
		pointCut.setExpression("execution(* com.gdu.app08.service.*Impl.*Transaction(..))");
		//* *Impl : Impl로 끝나는 모든 클래스
		
		return new DefaultPointcutAdvisor(pointCut, transactionInterceptor());
	}
}
