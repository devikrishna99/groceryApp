package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.Pageutility;


public class ManageContact {

	public WebDriver driver;
	Pageutility page = new Pageutility();
	FakerUtility faker = new FakerUtility();

	public ManageContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1' ]")
	WebElement editButton;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phonenumberUpdate;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailUpdate;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressUpdate;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliveryTimeUpdate;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement deliveryChargeLimit;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class= 'alert alert-success alert-dismissible']")
	WebElement alertMessage;

	public ManageContact clickonEditButton() {
		editButton.click();
		return this;
	}

	public ManageContact updateDetails() {
		phonenumberUpdate.clear();
		phonenumberUpdate.sendKeys(faker.generatePhnoneNO());
		emailUpdate.clear();
		emailUpdate.sendKeys(faker.generateEmailid());
		addressUpdate.clear();
		addressUpdate.sendKeys(faker.generateAddress());
		deliveryTimeUpdate.clear();
		deliveryTimeUpdate.sendKeys("10:30");
		deliveryChargeLimit.clear();
		deliveryChargeLimit.sendKeys("400");
		return this;
	}

	public ManageContact clickonupdateButton() {
		page.clickJavaScriptExecutor_scrolluntilElementVisible(updateButton, driver);
		page.clickJavaScriptExecutor(updateButton, driver);
		return this;

	}

	public boolean isAlertMessageDisplayed() {
		return alertMessage.isDisplayed();
	}

}
