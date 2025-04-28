package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();   
	public synchronized static ExtentReports createExtentReports() {    

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //it handles the creation and configuration of html report
		
		reporter.config().setReportName("Grocery Application");  
		extentReports.attachReporter(reporter);   
		extentReports.setSystemInfo("Organization", "Obsqura");  //add system level infm
		extentReports.setSystemInfo("Name", "Devi ");
		return extentReports;   //return the report

}
}