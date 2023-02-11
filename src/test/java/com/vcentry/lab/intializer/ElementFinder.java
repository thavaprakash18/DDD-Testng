

package com.vcentry.lab.intializer;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

public class ElementFinder extends Intializer{
	public static  WebElement findById(String id) {

		try{
		WebElement element= wd.findElement(By.id(locatorProp.getProperty(id)));
		return element;
		} catch (NoSuchElementException e) {
			System.out.println("Unable to find elemnet by id"+ e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("Unable to intract elemnet by id"+ e.getMessage());
		}
		return null; 
	}

	public static WebElement findByName(String name) {
		try{
			WebElement element= wd.findElement(By.name(locatorProp.getProperty(name)));
			return element;
			} catch (NoSuchElementException e) {
				System.out.println("Unable to find elemnet by id"+ e.getMessage());
			} catch (ElementNotInteractableException e) {
				System.out.println("Unable to intract elemnet by id"+ e.getMessage());
			}
			return null;
	}

	public static WebElement findByXpath(String xpath) {
		try{
			WebElement element= wd.findElement(By.xpath(locatorProp.getProperty(xpath)));
			return element;
			} catch (NoSuchElementException e) {
				System.out.println("Unable to find elemnet by id"+ e.getMessage());
			} catch (ElementNotInteractableException e) {
				System.out.println("Unable to intract elemnet by id"+ e.getMessage());
			}
			return null;
	}

	public static WebElement findByCSS(String css) {
		try{
			WebElement element= wd.findElement(By.cssSelector(locatorProp.getProperty(css)));
			return element;
			} catch (NoSuchElementException e) {
				System.out.println("Unable to find elemnet by id"+ e.getMessage());
			} catch (ElementNotInteractableException e) {
				System.out.println("Unable to intract elemnet by id"+ e.getMessage());
			}
			return null;
	}

	public static WebElement findByLinkText(String linkText) {
		try{
			WebElement element= wd.findElement(By.linkText(locatorProp.getProperty(linkText)));
			return element;
			} catch (NoSuchElementException e) {
				System.out.println("Unable to find elemnet by id"+ e.getMessage());
			} catch (ElementNotInteractableException e) {
				System.out.println("Unable to intract elemnet by id"+ e.getMessage());
			}
			return null;
	}

	public static WebElement findByPartialLink(String partialLink) {
		try{
			WebElement element= wd.findElement(By.partialLinkText(locatorProp.getProperty(partialLink)));
			return element;
			} catch (NoSuchElementException e) {
				System.out.println("Unable to find elemnet by id"+ e.getMessage());
			} catch (ElementNotInteractableException e) {
				System.out.println("Unable to intract elemnet by id"+ e.getMessage());
			}
			return null;
	}

	public static WebElement findByClassName(String classname) {
		try{
			WebElement element= wd.findElement(By.className(locatorProp.getProperty(classname)));
			return element;
			} catch (NoSuchElementException e) {
				System.out.println("Unable to find elemnet by id"+ e.getMessage());
			} catch (ElementNotInteractableException e) {
				System.out.println("Unable to intract elemnet by id"+ e.getMessage());
			}
			return null;
	}

	public static WebElement findByTagName(String tagName) {
		try{
			WebElement element= wd.findElement(By.tagName(locatorProp.getProperty(tagName)));
			return element;
			} catch (NoSuchElementException e) {
				System.out.println("Unable to find elemnet by id"+ e.getMessage());
			} catch (ElementNotInteractableException e) {
				System.out.println("Unable to intract elemnet by id"+ e.getMessage());
			}
			return null;
	}
}



