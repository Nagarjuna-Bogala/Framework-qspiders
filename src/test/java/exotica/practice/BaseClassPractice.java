package exotica.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice {
	
	@BeforeSuite
	
	public void bsConfig()
	{
		System.out.println("Before suite");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("After suite");
	}
	
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("Before class");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("After class");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void amConfigOO()
	{
		System.out.println("After method");
	}
	
	@Test
	public void test1()
	{
		System.out.println("test-1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("test-2");
	}
	
	@Test
	public void test3()
	{
		System.out.println("test-3");
	}
}
