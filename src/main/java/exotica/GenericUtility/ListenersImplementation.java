package exotica.GenericUtility;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class acts like a implimentation class to override all the methods
 * present in ITestListener interface
 * @author nagar
 *
 */
public class ListenersImplementation implements ITestListener {
	
	JavaUtility jLib= new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		
		//Reporter.log(methodName+" script execution started",true);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
		test.log(Status.PASS,methodName+"----> passed");
		//Reporter.log(methodName+"  is passed ",true);
	}

	public void onTestFailure(ITestResult result) {
		
		//this will capture the exception occured
		//String msg = result.getThrowable().toString();
		
		//this will capture the current test method name
		String methodName = result.getMethod().getMethodName();
		
		//This will append method name with date for screenshot
		String screenShotName = methodName+"-"+jLib.getSystemDateInFormat();
		
		test.log(Status.FAIL,methodName+"----> Failed");
		test.log(Status.FAIL,result.getThrowable());
		
		//Reporter.log(methodName+"  is failed because "+msg,true);
		
		//This will capture the screen shot and provide the screen shot name and save it in folder
		try {
			
			String path = wLib.takeScreenShot(BaseClass.sdriver, screenShotName);
			
			test.addScreenCaptureFromPath(path);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		//String msg = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName+"----> Skipped");
		test.log(Status.SKIP,result.getThrowable());
		
		//Reporter.log(methodName+" is skipped because "+msg,true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		//Start of suite execution
		/*configure the extent reports*/
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+jLib.getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Exotica Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Exotica Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-platform", "Windows");
		report.setSystemInfo("Base-URL","http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Nagarjuna");
		
	}

	public void onFinish(ITestContext context) {
		
		//End of suite execution
		report.flush();
	}

	
	
	
	
	
	
	
}
