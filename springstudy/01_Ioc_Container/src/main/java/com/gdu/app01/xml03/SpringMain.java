package com.gdu.app01.xml03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("xml03/appCtx.xml");
		Person ijm = ctx.getBean("injelmi", Person.class);
		
		System.out.println(ijm.getName());
		System.out.println(ijm.getAge());
		Address addr = ijm.getAddr();
		System.out.println(addr.getJibun());
		System.out.println(addr.getRoad());
		System.out.println(addr.getZipCode());
		
		ctx.close();
		
	}

}
