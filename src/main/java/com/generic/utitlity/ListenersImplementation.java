package com.generic.utitlity;

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
 * This class contains Implementation of ITestListener
 * 
 * @author vivek
 *
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ***** IT execution started ***** ");

		test = reports.createTest(methodName);
		test.log(Status.INFO, methodName + " : Execution Started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ***** Test execution successful ***** ");
		test.log(Status.PASS, methodName + " : Script Pass");
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ***** Test execution failed ***** ");
		test.log(Status.FAIL, methodName + " : Script Fail");
		test.log(Status.WARNING, result.getThrowable());

		// Take Screen Shot
		String scr = methodName + "-" + new JavaUtility().getSystemDateInFormate();
		WebDriverUtility wutil = new WebDriverUtility();
		try {
			String path = wutil.takeScreenShot(BaseClass.SDriver, scr);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ***** Test execution Skiped ***** ");
		test.log(Status.SKIP, methodName + " : Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		System.out.println(" ***** Execution Started ***** ");

		// Configure Extent Spark Report
		ExtentSparkReporter html = new ExtentSparkReporter(
				".\\ExtentReport\\Report-" + new JavaUtility().getSystemDateInFormate() + ".html");
		html.config().setDocumentTitle("VTiger 2 Execution Report");
		html.config().setReportName("Execution Report V1.0");
		html.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(html);
		reports.setSystemInfo("Base Browser", "Chrome");
		reports.setSystemInfo("Base URL", "http://TestEnv.com");
		reports.setSystemInfo("Base Platform", "Windows-Family");
		reports.setSystemInfo("Reporter Name", "Vivek");
	}

	public void onFinish(ITestContext context) {
		System.out.println(" ***** Execution Finished ***** ");
		reports.flush(); // Responsible for report generation.
	}

}
