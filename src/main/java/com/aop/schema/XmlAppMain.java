package com.aop.schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAppMain 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		XmlOperation e = (XmlOperation) context.getBean("opBean");
		((ClassPathXmlApplicationContext) context).close();
		
		System.out.println("calling getMsg...");
		e.getMsg();
		
		System.out.println("\n\ncalling msg...");
		e.msg();
		
		System.out.println("\n\ncalling checkValue...");
		e.checkValue(15);
		
		System.out.println("\n\ncalling getAge...");
		e.getAge(20);
		
		try{
		System.out.println("\n\ncalling validate...");
		e.validate(15);
		}catch(ArithmeticException ae)
		{
			System.out.println("Exception thrown"+ae);
		}
    }
}
