package exotica.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(invocationCount = 2)
	public void CreateCustomerTest(){
		Assert.fail();
		System.out.println("Tc-01 -Customer is created");
	}
	
	@Test(priority = 1, dependsOnMethods = "CreateCustomerTest")
	public void ModifyCustomerTest() {
		System.out.println("Tc-02 -Customer is modified");
	}
	
	@Test(priority = 2, enabled = false)
	public void DeleteCustomerTest() {
		System.out.println("Tc-03 -Customer is deleted");
	}

}
