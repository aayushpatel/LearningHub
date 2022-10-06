package aayushpatelframework.resources;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentrepots {

	public static ExtentReports getReportObject() {
		Date d = new Date();
		String path = System.getProperty("user.dir") + "//reports//Report" + d.getTime() + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Shoping cart");
		reporter.config().setReportName("regression");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("testerName", "Aayush");
		extent.createTest(path);
		return extent;

	}
}
