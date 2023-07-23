package loginPage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {

	public ExtentSparkReporter spartReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext context) {
		spartReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Report/myloginpage.html");
		spartReporter.config().setDocumentTitle("ReportofLoginPage");
		spartReporter.config().setReportName("LoginpageObject");
		spartReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(spartReporter);

		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", "Window");
		extent.setSystemInfo("Tester", "Ankit Singh");

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case PASSED is:" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());

	}

	public void onFinish(ITestContext context) {

		extent.flush();
	}

}
