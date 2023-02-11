package com.vcentry.lab.intializer;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vcentry.lab.utils.ReportOptimizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Intializer {
	public static boolean isReport=false;
	/**@author thava
	 * @date 25-01-2023
	 * @purpose declare report variable
	 * 
	 */public static ExtentReports reports;
		public static ExtentTest log;
		
		
		/**@author thava
		 * @date 25-01-2023
		 * @purpose declare webdriver variable
		 * 
		 */public static WebDriver wd=null;
	
	/**@author thava
	 * @date 20-01-2023
	 * @purpose declare envionment variables
	 * 
	 */
	public static FileInputStream envFis=null;;
	public static Properties envProp=null;
	
	/**@author thava
	 * @date 20-01-2023
	 * @purpose declare locator variables
	 * 
	 */
	public static FileInputStream locatorFis=null;;
	public static Properties locatorProp=null;
	
	/**@author thava
	 * @date 20-01-2023
	 * @purpose initialize the environment,locator,excel,report,WebDriver variables
	 * 
	 */
	public static void initialize() throws IOException{
		if (!isReport) { //becomes true
			reports = new ExtentReports("C:/Batch251/K1_DDDTest/report/index.html");
			isReport = true; // once generated report is true
			ReportOptimizer.optimizeReport();
		}
		

	envFis = new FileInputStream(new File("src/test/resources/com/vcentry/lab/config/env.properties"));
	envProp= new Properties();
	envProp.load(envFis);
	
	locatorFis = new FileInputStream(new File("src/test/resources/com/vcentry/lab/config/locator.properties"));
	locatorProp= new Properties();
	locatorProp.load(locatorFis);
	if (envProp.get("Browser").equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
    }else if (envProp.get("Browser").equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		wd = new FirefoxDriver();
    }else if (envProp.get("Browser").equals("ie")) {
		WebDriverManager.iedriver().setup();
		wd = new InternetExplorerDriver();
		
	}wd.manage().window().maximize();
	 wd.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //maximum page load time set by us;
	 
	 
	 
	 wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
