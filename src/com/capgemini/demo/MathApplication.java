package com.capgemini.demo;

import com.capgemini.demo.exception.InputInvalidException;
import com.capgemini.demo.service.CalculatorService;

public class MathApplication {
	
	private CalculatorService service;

	public MathApplication(CalculatorService service) {
		
		this.service = service;
	}
	
	public int perfomAddition(int number1,int number2)
	{
		return service.addition(number1, number2);
	}
	
	public int perfomSubtraction(int number1,int number2)
	{
		return service.subtraction(number1, number2);
		
	}
	
	public int perfomMultiplication(int number1,int number2)
	{
		return service.multiplication(number1, number2);
	}
	
	public int perfomDivision(int number1,int number2)
	{
		return service.division(number1, number2);
	}
	
	public long findFactorial(int number)throws InputInvalidException
	{
		return service.factorial(number);
	}
	
	public long findSquare(int number)
	{
		return service.square(number);
	}
}
