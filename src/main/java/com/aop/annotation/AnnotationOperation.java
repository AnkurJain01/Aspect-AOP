package com.aop.annotation;

import org.springframework.stereotype.Component;

@Component("opBean")
public class AnnotationOperation {

	public void msg() {
		System.out.println("msg method invoked");
	}

	public void validate(int age) throws ArithmeticException {
		if (age < 18) {
			throw new ArithmeticException("Not valid age");
		} else {
			System.out.println("Valid Age");
		}
	}
	
	public int getAge(int age)
	{
		return age;
	}
	
	public void getMsg()
	{
		System.out.println("getMsg method invoked");
	}
	
	public void checkValue(int number)
	{
		if(number==15)
		{
			System.out.println("Number is 15");
		}
	}

}
