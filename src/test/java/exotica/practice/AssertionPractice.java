package exotica.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void assertionTest()
	{
		System.out.println("---step-1---");
		System.out.println("---step-2---");
		System.out.println("---step-3---");
		System.out.println("---step-4---");
		Assert.assertEquals(true, true);
		System.out.println("---step-5---");
	}

	@Test
	public void assertionTest2()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("---test-2 step-1---");
		System.out.println("---test-2 step-2---");
		System.out.println("---test-2 step-3---");
		sa.assertTrue(true);
		System.out.println("---test-2 step-4---");
		System.out.println("---test-2 step-5---");
		sa.assertAll();
		
	
	}
}
