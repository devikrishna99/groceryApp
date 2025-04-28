package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;

public class ManageFooterText {

	public WebDriver driver;
	FakerUtility faker = new FakerUtility();

	public ManageFooterText(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")
	WebElement updateFooterTextInfo;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressField;
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNumberField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateButton_InUpdateFooterInfo;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='btn btn-default btn-fix']")
	WebElement resetButton;

	public ManageFooterText clickonUpdateFooterText() {
		updateFooterTextInfo.click();
		return this;
	}

	public ManageFooterText updateDetails() {
		addressField.clear();
		addressField.sendKeys(faker.generateAddress());
		emailField.clear();
		emailField.sendKeys(faker.generateEmailid());
		phoneNumberField.clear();
		phoneNumberField.sendKeys(faker.generatePhnoneNO());
		return this;
	}

	public ManageFooterText clickonupdate_InFooterInfo() {

		updateButton_InUpdateFooterInfo.click();
		return this;
	}

	public boolean alertmessageDisplayed() {
		return alertMessage.isDisplayed();
	}

	public ManageFooterText clickonresetButton() {
		resetButton.click();
		return this;
	}

}
