package ngan.xd.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Report/ExtentReport/ExtentReport.html");
        reporter.config().setReportName("Final Stone Project Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("TestNG", "Selenium Java Framework | Ngan Dang");
        extentReports.setSystemInfo("Author", "Ngan Dang");
        return extentReports;
    }
}
