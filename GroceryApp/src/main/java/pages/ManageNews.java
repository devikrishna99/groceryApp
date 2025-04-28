package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.FileupLoadUtility;
import utilities.Pageutility;


public class ManageNews {
	public WebDriver driver;
	Pageutility page = new Pageutility();
	FileupLoadUtility upload = new FileupLoadUtility();
	FakerUtility faker = new FakerUtility();

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newNewsArea;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteNewsButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deletedAlertMessage;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement updateBtton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement editNewsArea;
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement updateButton_InUpdate;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newsUpdatedAlertMessage;

	public ManageNews clickonNewButton() {
		newButton.click();
		return this;
	}

	public ManageNews enter_newNews() {
		newNewsArea.sendKeys(faker.generatenews());
		return this;

	}

	public ManageNews clickonSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean isalertMessageDisplyed() {
		return alertMessage.isDisplayed();

	}

	public ManageNews clickonDeleteNewsButton() {
		deleteNewsButton.click();
		return this;
	}

	public ManageNews accept_Alertmessage() {
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isdeletedAlertMessageDisplayed() {
		return deletedAlertMessage.isDisplayed();
	}

	public ManageNews clickonUpdateButton() {
		updateBtton.click();
		return this;
	}

	public ManageNews updateNewsArea() {
		editNewsArea.clear();
		editNewsArea.sendKeys(faker.generatenews());
		return this;
	}

	public ManageNews clickonUpdateinUpdatePage() {
		updateButton_InUpdate.click();
		return this;
	}

	public boolean isUpdatedAlertMessageDisplyed() {
		return newsUpdatedAlertMessage.isDisplayed();
	}

}
