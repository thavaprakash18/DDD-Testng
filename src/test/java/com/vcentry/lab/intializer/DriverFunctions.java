package com.vcentry.lab.intializer;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DriverFunctions {
	public static  void selectByIndex(WebElement element,int index) {

		try{
		Select s = new Select(element);
		s.selectByIndex(index);
		
		} catch (NoSuchElementException e) {
			System.out.println("Unable to find element "+ e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("Unable to intract element"+ e.getMessage());
		}
		
	}
	public static  void selectByText(WebElement element,String text) {

		try{
		Select s = new Select(element);
		s.selectByVisibleText(text);
		
		} catch (NoSuchElementException e) {
			System.out.println("Unable to find element "+ e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("Unable to intract element"+ e.getMessage());
		}
		
	}
	public static  void selectByValue(WebElement element,String value) {

		try{
		Select s = new Select(element);
		s.selectByValue(value);
		
		} catch (NoSuchElementException e) {
			System.out.println("Unable to find element "+ e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("Unable to intract element"+ e.getMessage());
		}
		
	}

}
