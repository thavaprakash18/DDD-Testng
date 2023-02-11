package com.vcentry.lab.reportGenerator;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.lab.intializer.Intializer;

public class ReportGenerator extends Intializer {
	public static void generateScreenshot(ITestResult it) throws IOException{
		Object[] args=it.getParameters();
		String tcName =  args[0].toString();
		
		if (it.isSuccess()) {
			String path = takeScreenshot(tcName);
			log.log(LogStatus.PASS,tcName + " test case pass", log.addScreenCapture(path));
		} else {
			String path = takeScreenshot(tcName);
			log.log(LogStatus.FAIL, tcName + " testcase failed", log.addScreenCapture(path));
		}
		reports.endTest(log);
		reports.flush();
	}
	
	public static String takeScreenshot(String name) throws IOException {
		File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		File dst = new File("C:/Batch251/K1_DDDTest/screenshot/"+name+".png");
		FileHandler.copy(src, dst);
		///System.out.println(dst.toString());
		return dst.toString();
	}
}
