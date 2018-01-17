package com.aop.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Main Class to start annotation based aop application along with configuration
 *
 */
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"com.aop.annotation"})
public class AnnotationAppMain 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationAppMain.class);
		AnnotationOperation e = (AnnotationOperation) context.getBean("opBean");
		((AnnotationConfigApplicationContext) context).close();
		
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
			System.out.println("Exception Thrown"+ae);
		}
    }
}
