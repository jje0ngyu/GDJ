package com.gdu.app01.xml05;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) throws Exception {
		
		// 프로젝트의 Build Path에 ojdbc6.jar 등록하고 실행한다.
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml05/appCtx.xml");
		MyConnection myCon = ctx.getBean("conn", MyConnection.class);
		Connection con = myCon.getconConnection();
		
		if (con != null) {
			con.close();
			System.out.println("Connection 접속 종료");
		}
		
		ctx.close();
	}

}
