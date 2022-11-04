package com.gdu.app07;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.junit.runners.model.InitializationError;
import org.springframework.jndi.JndiTemplate;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// SpringJUnit4ClassRunner를 대신하는 클래스
//* JUnit에서는 톰캣(sql컨테이너)가 작동하지 않아 데이터를 받지 못한다.
//* 때문에 DataSource에서 제공하는 데이터베이스를 사용하는 코드를 이 페이지에서 작성한다. 
// SpringJUnit4ClassRunner를 상속 받아서 만들어야 한다. (SuperClass에 추가)
public class MySpringJUnit4ClassRunner extends SpringJUnit4ClassRunner {
	
	public MySpringJUnit4ClassRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
		jndi();
	}
	
	private void jndi() {
		// JNDI 방식으로 "java:comp/env/jdbc/oracle11g" 이름의 Resource를 추가하면
		// 톰캣이 확인하는 context.xml을 참조하는 대신
		// 여기서 만든 BasicDataSource를 사용하시오.
		try {
			
			/*------------------------------------------------------------------------
			   SimpleNamingContextBuilder는 현재 사용하지 않는 것이 좋다. (옛날 코드)
			-------------------------------------------------------------------------- */
			SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
			builder.activate();
			
			/*------------------------------------------------------------------------
			   JUnit을 사용할 때 데이터를 불러오는 코드
			-------------------------------------------------------------------------- */
			BasicDataSource dataSource = new BasicDataSource();
			/*
			 	BasicDataSource를 사용하기 위해선 TOMCAT-DBCP 디펜던시가 필요하다.
			 	주소 : https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-dbcp/9.0.68
			*/
			dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			dataSource.setUsername("SCOTT");
			dataSource.setPassword("TIGER");
			
			JndiTemplate jndiTemplate = new JndiTemplate();
			jndiTemplate.bind("java:comp/env/jdbc/oracle11g", dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
