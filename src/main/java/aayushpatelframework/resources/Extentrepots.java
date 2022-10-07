package aayushpatelframework.resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentrepots {

	public static ExtentReports getReportObject() {
		Date d = new Date();
		String dateval = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(d);
		String path = System.getProperty("user.dir") + "//reports//Report" + dateval + ".html";
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
