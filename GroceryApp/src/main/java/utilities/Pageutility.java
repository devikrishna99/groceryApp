package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Pageutility {
	public String selectDropdownWithValue(WebElement element, String value) {
		
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	public String selectDropdownWithVisibleText(WebElement element,String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement selectElement = object.getFirstSelectedOption();
		return selectElement.getText();
	}
	public String selectfromsearchCategory(WebElement element1,String text1) {
		Select obj = new Select(element1);
		obj.selectByContainsVisibleText(text1);
		WebElement selectElement = obj.getFirstSelectedOption();
		return selectElement.getText();
		
	}
public String selectDropdownWithIndex(WebElement element, int index) {
		
		Select select = new Select(element);
		select.selectByIndex(index);
		WebElement selectedElement = select.getFirstSelectedOption();
		return selectedElement.getText();
	}
public void clickJavaScriptExecutor_scrolluntilElementVisible(WebElement element, WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);",element);
	
}

}
