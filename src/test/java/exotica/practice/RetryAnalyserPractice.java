package exotica.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {

	@Test(retryAnalyzer = exotica.GenericUtility.RetryAnalyserImplementation.class)
	public void retryAnalyserPractice(){
		System.out.println("Hi");
		Assert.fail();
	}
}
