package utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	public static int implicitwaitduration = 50;
	public static int explicitwaitduration = 25;
	public static int fluentwaitduration = 25;

	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}

	public void waitUntilElementisVisible(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitduration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForWebElementAlert(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitduration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForElementTobeClicable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitduration));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitForPageToLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitduration));
		wait.withTimeout(Duration.ofSeconds(explicitwaitduration));
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitwaitduration));
	}
	public void waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> elements) {
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(explicitwaitduration));
	            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

}