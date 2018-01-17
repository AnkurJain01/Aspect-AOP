package com.aop.annotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationTrackOperation{  
	
	@After("execution(* com.aop.annotation.AnnotationOperation.msg(..))")
	public void afterAdvice(JoinPoint jp)
	{
		System.out.println("Inside afterAdvice method");
		System.out.println("Method Signature: "  + jp.getSignature());
	}
	
	@Before("execution(* com.aop.annotation.AnnotationOperation.getMsg(..))")
	public void beforeAdvice(JoinPoint jp)
	{
		System.out.println("Inside beforeAdvice method");
		System.out.println("Method Signature: "  + jp.getSignature());
	}
	
	@Around("execution(* com.aop.annotation.AnnotationOperation.checkValue(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable 
	{
		System.out.println("Inside aroundAdvice method");
		System.out.println("Before calling actual method");
		Object obj=pjp.proceed();
		System.out.println("After calling actual method");
		return obj;
	}
	
	@AfterThrowing(pointcut="execution(* com.aop.annotation.AnnotationOperation.validate(..))",
			throwing="error")
	public void afterThrowingAdvice(JoinPoint jp,Throwable error)
	{
		System.out.println("Inside afterThrowingAdvice method");
		System.out.println("Method Signature: "  + jp.getSignature());
		System.out.println("Exception is: "+error);
		System.out.println("end of after throwing advice...");
	}
	
	@AfterReturning(pointcut="execution(* com.aop.annotation.AnnotationOperation.getAge(..))",
            returning= "result")
	public void afterReturnAdvice(JoinPoint jp,Object result)
	{
		System.out.println("Inside afterReturnAdvice method");
		System.out.println("Method Signature: "  + jp.getSignature());
		System.out.println("Result in advice: "+result);
		System.out.println("end of after returning advice...");
	}
	
}  
