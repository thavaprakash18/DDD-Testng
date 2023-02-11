
package com.vcentry.lab.testCases;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.lab.Pages.CheckoutPage;
import com.vcentry.lab.Pages.HomePage;
import com.vcentry.lab.Pages.LoginPage;
import com.vcentry.lab.inputReader.InputReader;
import com.vcentry.lab.intializer.ElementFinder;
import com.vcentry.lab.intializer.Intializer;
import com.vcentry.lab.reportGenerator.ReportGenerator;


public class CheckoutPageValidator extends Intializer{
	@BeforeMethod
   	public void setUp() throws IOException {
    	if (wd==null) {
    		initialize();
		}
    }
	  /*	@BeforeClass
   	public void setUp() throws IOException {
    	initialize();
    }   */
	
    @Test(dataProvider="checkoutpagedata")
	public  void validateCheckoutPage(String dataSetName,String username,String password,String productName,String mobileNum,String emailId,String productCat,String productQty, String purchaserName) throws IOException{
		//initialize();
		wd.get(envProp.getProperty("URL"));

		 log=reports.startTest(dataSetName+"initiated");
		// Login page
			LoginPage.enterUserName(username);//0
			LoginPage.enterPassword(password);//1
			LoginPage.submitLoginPage();
		// Home page
		wd.get(envProp.getProperty("LAB_URL"));
		HomePage.clickFrameworkForm();
		HomePage.clickSimpleForm();
		log.log(LogStatus.PASS, "HomePage loaded successfully");
		//System.out.println("test case excuted with"+dataSetName);
		// checkout page
		CheckoutPage.enterProdutName(productName);//2
		CheckoutPage.enterMobileNumber(mobileNum);//3
		CheckoutPage.enterEmailId(emailId);//4
		CheckoutPage.selectProductCat(productCat);//5
		CheckoutPage.enterProdutQty(productQty);//6
		CheckoutPage.enterPruchaserName(purchaserName);//7
		CheckoutPage.clickGstYes();
		CheckoutPage.clickCOD();
		CheckoutPage.clickPlaceOrder();
         log.log(LogStatus.PASS, "CheckoutPage loaded successfully");
	
      /* //Step 3
  		// Login page
		ElementFinder.findById("LOGINPAGE_TYPE_USERNAME_ID").sendKeys("THAVAPRAKASH");
		ElementFinder.findById("LOGINPAGE_TYPE_PASSWORD_ID").sendKeys("divya@18");
		ElementFinder.findById("LOGINPAGE_TYPE_PASSWORD_ID").submit();
		//Home page
		wd.get(envProp.getProperty("LAB_URL"));
		ElementFinder.findById("HOMEPAGE_CLICK_FRAMEWORKFORM_ID").click();
		ElementFinder.findById("HOMEPAGE_CLICK_SIMPLEFORM_ID").click();
		//checkout page
		ElementFinder.findById("CHECKOUT_TYPE_PRODUCTNAME_ID").sendKeys("product A");
		ElementFinder.findById("CHECKOUT_TYPE_MOBILE_ID").sendKeys("123456");
		ElementFinder.findById("CHECKOUT_TYPE_EMAIL_ID").sendKeys("maila@mail.com");
		WebElement dropdown = ElementFinder.findById("CHECKOUT_SELECT_PRODUCTCAT_ID");

		Select s = new Select(dropdown);
		s.selectByVisibleText("Electrical");

		ElementFinder.findById("CHECKOUT_TYPE_PRODUCTQTY_ID").sendKeys("10");
		ElementFinder.findById("CHECKOUT_TYPE_PURCHASERNAME_ID").sendKeys("purchaser A");
		ElementFinder.findById("CHECKOUT_CLICK_GSTYES_ID").click();
		ElementFinder.findById("CHECKOUT_CHECK_COD_ID").click();
		ElementFinder.findById("CHECKOUT_CLICK_PLACEORDER_ID").click();
        */
		
	}
    @DataProvider(name="checkoutpagedata")
	public static Object[][] getData() throws IOException{
    	if (InputReader.verifyRunMode("CheckoutPageValidator")) {
			Object [][] data =InputReader.verifyMultiData("CheckoutPageValidator");
			return data;
    	}
		return null;
    		
    		
		
    		 /* 	Object [][] data=new Object[3][9];
    	//first data set
		data[0][0]="checkoutdataset1";
		data[0][1]="user1";
		data[0][2]="Guru@12345";
		data[0][3]="Product A";
		data[0][4]="1111111111";
		data[0][5]="mailA@mail.com";
		data[0][6]="Electrical";
		data[0][7]="10";
		data[0][8]="purchaser A";
		//second data set
		data[1][0]="checkoutdataset2";
		data[1][1]="user1";
		data[1][2]="Guru@12345";
		data[1][3]="Product B";
		data[1][4]="2222222222";
		data[1][5]="mailB@mail.com";
		data[1][6]="Electrical";
		data[1][7]="20";
		data[1][8]="purchaser B";
		
		data[2][0]="checkoutdataset3";
		data[2][1]="user1";
		data[2][2]="Guru@12345";
		data[2][3]="Product C";
		data[2][4]="3333333333";
		data[2][5]="mailC@mail.com";
		data[2][6]="Electrical";
		data[2][7]="30";
		data[2][8]="purchaser C";
		return data;
    	}
		return null; */
	}
	@AfterMethod
	public void teardown(ITestResult it) throws IOException {
		
		ReportGenerator.generateScreenshot(it);
		HomePage.clickLogout();
	}

	

    
    @AfterClass
   	public void closeBrowser() {
    	wd.quit();
    }

    
    
}
