package com.aop.schema;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class XmlTrackOperation{  
	
	public void afterAdvice(JoinPoint jp)
	{
		System.out.println("Inside afterAdvice method");
		System.out.println("Method Signature: "  + jp.getSignature());
	}
	
	public void beforeAdvice(JoinPoint jp)
	{
		System.out.println("Inside beforeAdvice method");
		System.out.println("Method Signature: "  + jp.getSignature());
	}
	
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable 
	{
		System.out.println("Inside aroundAdvice method");
		System.out.println("Before calling actual method");
		Object obj=pjp.proceed();
		System.out.println("After calling actual method");
		return obj;
	}
	
	public void afterThrowingAdvice(JoinPoint jp,Throwable error)
	{
		System.out.println("Inside afterThrowingAdvice method");
		System.out.println("Method Signature: "  + jp.getSignature());
		System.out.println("Exception is: "+error);
		System.out.println("end of after throwing advice...");
	}
	
	public void afterReturnAdvice(JoinPoint jp,Object result)
	{
		System.out.println("Inside afterReturnAdvice method");
		System.out.println("Method Signature: "  + jp.getSignature());
		System.out.println("Result in advice: "+result);
		System.out.println("end of after returning advice...");
	}
	
}  
