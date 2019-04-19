package com.capgemini.demo.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.demo.MathApplication;
import com.capgemini.demo.exception.InputInvalidException;

import com.capgemini.demo.service.CalculatorService;

public class MathApplicationTest {
	
	
	@Mock
	public CalculatorService service;
	
	
	@InjectMocks
	MathApplication application = new MathApplication(service);

	@Before
	public void setUp() 
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testToPerformAddition()
	{
		when(service.addition(5, 5)).thenReturn(10);
		assertEquals(10,application.perfomAddition(5, 5));
	}
	@Test
	public void testToPerformAdditionOnevalueisNegetive()
	{
		when(service.addition(5, -5)).thenReturn(0);
		assertEquals(0,application.perfomAddition(5, -5));
	}
	@Test
	public void testToPerformAdditionOnevalueisPositive()
	{
		when(service.addition(-10, 5)).thenReturn(5);
		assertEquals(5,application.perfomAddition(-10, 5));
	}
	@Test
	public void testToPerformAdditionTwoValuesNegative()
	{
		when(service.addition(-10, -5)).thenReturn(15);
		assertEquals(15,application.perfomAddition(-10, -5));
	}
	
	
	
	@Test
	public void testToPerfomSubtractionTowPositiveValues()
	{
		when(service.subtraction(8, 4)).thenReturn(4);
		assertEquals(4,application.perfomSubtraction(8, 4));
	}
	@Test
	public void testToPerfomSubtractionTowNegativeValues()
	{
		when(service.subtraction(-8, -4)).thenReturn(12);
		assertEquals(12,application.perfomSubtraction(-8, -4));
	}
	@Test
	public void testToPerfomSubtractionOneNegativeValues()
	{
		when(service.subtraction(-8, 4)).thenReturn(4);
		assertEquals(4,application.perfomSubtraction(-8, 4));
	}
	@Test
	public void testToPerfomSubtractionOnePositiveValues()
	{
		when(service.subtraction(12, -8)).thenReturn(4);
		assertEquals(4,application.perfomSubtraction(12, -8));
	}
	
	
	
	@Test
	public void testToPerfomMultiplication()
	{
		when(service.multiplication(5, 5)).thenReturn(25);
		assertEquals(25,application.perfomMultiplication(5, 5));
	}

	@Test
	public void testToPerfomMultiplicationTwoNegativeValues()
	{
		when(service.multiplication(-5, -5)).thenReturn(25);
		assertEquals(25,application.perfomMultiplication(-5, -5));
	}
	
	
	
	@Test
	public void testFindFactorialWithPositiveInteger() throws InputInvalidException  
	{
		when(service.factorial(5)).thenReturn(120L);
		assertEquals(120, application.findFactorial(5));

	}
	@Test
	public void testFindFactorialWithNagativevalue() throws InputInvalidException 
	{
		when(service.factorial(-5)).thenReturn(120L);
		assertEquals(120, application.findFactorial(-5));

	}
	@Test(expected = InputInvalidException.class)
	public void testFindFactorialWithlowerevalue()throws InputInvalidException 
	{
		doThrow(new InputInvalidException("factorial number is lessthan one")).when(service).factorial(0);
		application.findFactorial(0);

	}
	
	@Test(expected = ArithmeticException.class)
	public void testPerformDivisionWithDivisorZero() 
	{
		doThrow(new ArithmeticException("divisible by zero")).when(service).division(10, 0);
		application.perfomDivision(10, 0); 

	}
	@Test
	public void testToPerfomDivisionWithDivisoranyNumber()
	{
		when(service.multiplication(16, 4)).thenReturn(4);
		assertEquals(4,application.perfomMultiplication(16, 4));
	}
	@Test
	public void testToPerfomSquare()
	{
		when(service.square(4)).thenReturn(16L);
		assertEquals(16,application.findSquare(4));
	}
}

