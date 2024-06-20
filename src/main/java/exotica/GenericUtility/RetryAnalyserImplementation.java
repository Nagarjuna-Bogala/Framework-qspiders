package exotica.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will retry the failed test scripts due to synchronization issue
 * @author nagar
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count=0;
	int retryCount =4;// manually try and then give count
	
	public boolean retry(ITestResult result) {
		
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

	
	
}
