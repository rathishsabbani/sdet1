package Objectrepo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersImplementation  implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String failedTestCase = result.getMethod().getMethodName();
		String currentDate = new Date().toString().replace(":", "_").replace(" ", "_");
		EventFiringWebDriver ed=new EventFiringWebDriver(Baseclass.sdriver);
		File src = ed.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+failedTestCase+currentDate+".PNG");
		try {
     	FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

		

	}
