package ngan.xd.Listeners;

import com.aventstack.extentreports.Status;
import ngan.xd.helpers.CaptureHelpers;
import ngan.xd.utils.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ngan.xd.reports.AllureReportManager;
import ngan.xd.reports.ExtentReportManager;
import ngan.xd.reports.ExtentTestManager;

import java.io.IOException;

public class TestListeners implements ITestListener {
    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }


    @Override
    public void onStart(ITestContext result) {
        Log.info("Start Testing " + result.getName());
        System.out.println("onStart: " + result.getStartDate());
    }

    @Override
    public void onFinish(ITestContext result) {
        Log.info("End Testing" + result.getName());
        ExtentReportManager.getExtentReports().flush(); // kết thúc và thực thi xuất report
        System.out.println("onFinish: " + result.getEndDate());
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info(getTestName(result) + " test is starting...");
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Log.error("Test failed but it is in defined success ratio " + getTestName(result));
        ExtentTestManager.logMessage("Test failed but it is in defined success ratio " + getTestName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getName() + " is passed");
        ExtentTestManager.logMessage(Status.PASS, getTestName(result) + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            CaptureHelpers.takeScreenshot(result); // chụp màn hình khi fail
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Log.error(result.getName() + " is failed");

        //Extent Report
        ExtentTestManager.addScreenShot(Status.FAIL, "Evidence " + getTestName(result) + " failed");
        ExtentTestManager.logMessage(Status.FAIL, getTestName(result) + " is failed");

        //Allure report
        Log.error("Screenshot captured for test case: " + getTestName(result));
        AllureReportManager.saveTextLog(getTestName(result) + "is failed and screenshot taken!");
        AllureReportManager.saveScreenshotPNG();

        //In log error khi lỗi vào report
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Đây là test case bị bỏ qua: " + result.getName());
        ExtentTestManager.logMessage(Status.SKIP, getTestDescription(result) + " is skipped");
    }
}
