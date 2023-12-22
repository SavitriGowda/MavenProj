package UtilClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import TestBaseClass.TestBase;

public class UtilClass extends TestBase{
	public static void selectOption(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
}
