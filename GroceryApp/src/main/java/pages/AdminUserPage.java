package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.Pageutility;


public class AdminUserPage {

	public WebDriver driver;
	FakerUtility faker = new FakerUtility();
	Pageutility page = new Pageutility();
	

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passWordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropDown;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class = 'alert alert-success alert-dismissible']")
	WebElement alertisDisplayed;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement updatebutton;
	@FindBy(xpath = "//input[@type='password']")
	WebElement updatepasswordField;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement updateUserTypeDropDown;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton_InUpdate;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updatedAlertDisplay;

	public AdminUserPage clickonNewButton() {
		newButton.click();
		return this;

	}

	public AdminUserPage enterUserName() {
		usernameField.sendKeys(faker.generateName());
		return this;
	}

	public AdminUserPage enterPassword() {
		passWordField.sendKeys(faker.generatePassword());
		return this;
	}

	public AdminUserPage selectfromDropDown() {
		page.selectDropdownWithIndex(userTypeDropDown, 1);
		return this;
	}

	public AdminUserPage clickonSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alertisDisplayed.isDisplayed();
	}

	public AdminUserPage clickonUpdateButton() {
		updatebutton.click();
		return this;
	}

	public AdminUserPage changePassword() {
		updatepasswordField.clear();
		updatepasswordField.sendKeys(faker.generatePassword());
		return this;

	}

	public AdminUserPage updateUserType() {
		page.selectDropdownWithIndex(updateUserTypeDropDown, 3);
		return this;
	}

	public AdminUserPage clickonupdateinUpdatePage() {
		updateButton_InUpdate.click();
		return this;

	}

	public boolean updatedAlertDisplayed() {
		return updatedAlertDisplay.isDisplayed();
	}
}
