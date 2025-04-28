package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName_field;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement mart7text;
	@FindBy(xpath = "//div[@class ='alert alert-danger alert-dismissible']")
	WebElement alertMessage;

	public LoginPage enterUsernameonUsernameField(String username) {
		userName_field.sendKeys(username);
		return this;

	}

	public LoginPage enterPasswordOnpasswordField(String password) {
		passwordField.sendKeys(password);
		return this;

	}

	public LoginPage signinButtonClick() {
		signInButton.click();
		return this;
	}

	public boolean ishomePageLoded() {
		return mart7text.isDisplayed();

	}

	public boolean alerMessageBox() {
		return alertMessage.isDisplayed();

	}

	public HomePage loginByUsingExcelData() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		userName_field.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
		return new HomePage(driver);
	}
}
