package Demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener {
	
	ExtentReports er; 
	//it will monitor the listener class example when it is starting ending 
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String name = result.getName();
		//particualr test monitor
		test = er.createTest(name);
		
	}

	public void onTestSuccess(ITestResult result) {
		String name = result.getName();
		
		test.log(Status.PASS, name +"-------pass");
		
		
	}

	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		
		test.log(Status.FAIL, name+"---------fail");
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String name = result.getName();
		
		test.log(Status.SKIP,name+"-----------skipped");
		
	}

	public void onStart(ITestContext context) {
	     
		
	     ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReport\\"+4+".html");
	     //to provide title to the report
	     esr.config().setDocumentTitle("Final vtiger report");
	     // providing the theme or colour
	     esr.config().setTheme(Theme.STANDARD);
	     //providing the reporter name
	     esr.config().setReportName("Chaitu");
	     // extra relavant information about report
	     er= new ExtentReports();
	     
	     er.attachReporter(esr);
	     
	     er.setSystemInfo("Operating System", "window");
	     
	     er.setSystemInfo("Language", "Java");
	     
	     
		
	}

	public void onFinish(ITestContext context) {
		
		//it is going to consolidate the report
		er.flush();
		
	}

	
	
	
	

}
