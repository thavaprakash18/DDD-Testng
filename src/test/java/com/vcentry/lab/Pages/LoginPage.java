package com.vcentry.lab.Pages;

import com.vcentry.lab.intializer.ElementFinder;

public class LoginPage {
 
	public static void enterUserName(String data) {
		try {
			ElementFinder.findById("LOGINPAGE_TYPE_USERNAME_ID").sendKeys(data);
		} catch (Exception e) {
			System.out.println("Log : unable to enter text in user name filed" + e.getMessage());
		}
	}
	
	public static void enterPassword(String data) {
		try {
			ElementFinder.findById("LOGINPAGE_TYPE_PASSWORD_ID").sendKeys(data);
		} catch (Exception e) {
			System.out.println("Log : unable to enter text in password name filed" + e.getMessage());
		}
	}
	public static void submitLoginPage() {
		try {
			ElementFinder.findById("LOGINPAGE_TYPE_PASSWORD_ID").submit();
		} catch (Exception e) {
			System.out.println("Log : unable to submit login page" + e.getMessage());
		}
	}

}


