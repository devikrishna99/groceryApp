package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FakerUtility;
import utilities.FileupLoadUtility;
import utilities.Pageutility;
import utilities.WaitUtilities;

public class SubCategory {
	public WebDriver driver;
	Pageutility page = new Pageutility();
	FileupLoadUtility upload = new FileupLoadUtility();
	WaitUtilities wait = new WaitUtilities();
	FakerUtility faker = new FakerUtility();

	public SubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//select[@name ='cat_id']")
	WebElement categorydropDown;
	@FindBy(xpath = "//input[@id ='subcategory']")
	WebElement subcategoryField;
	@FindBy(xpath = "//input[@name ='main_img']")
	WebElement chooseFileButton;
	@FindBy(xpath = "//button[@type ='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement sucessAlert;

	@FindBy(xpath = "//button[@name='update']")
	WebElement update;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement categorySearchDropdown;
	@FindBy(xpath = "//input[@placeholder='Sub Category']")
	WebElement subcategorySearchField;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButton_InSearch;
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement updateButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement selectCategory_Update;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement subcategory_InUpdate;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateButton_InUpdate;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updatedAlert;

	public SubCategory clickOnNewButton() {
		newButton.click();
		return this;
	}

	public SubCategory selectCategory() {
		page.selectDropdownWithVisibleText(categorydropDown, "Vegetable");
		return this;
	}

	public SubCategory enterSubcategory() {
		subcategoryField.sendKeys("veggiees" + page.generateCurrentDateAndTime());
		return this;
	}

	public SubCategory uploadImage() {
		String filepath = Constants.SUBCAT_IMAGE;
		upload.fileUpload_sendkeys(chooseFileButton, filepath);
		return this;
	}

	public SubCategory clickOnsaveButton() {
		page.clickJavaScriptExecutor(saveButton, driver);
		return this;
	}

	public boolean isAlertDisplayed() {
		return sucessAlert.isDisplayed();
	}

	public SubCategory clickonsearchButton() {
		searchButton.click();
		return this;
	}

	public SubCategory selectFromSearch_Category() {
		page.selectDropdownWithVisibleText(categorySearchDropdown, "Electronics");
		return this;
	}

	public SubCategory enterSubcategoryin_Search() {
		subcategorySearchField.sendKeys("Laptop" + page.generateCurrentDateAndTime());
		return this;
	}

	public SubCategory clickOnSearchButton() {
		searchButton_InSearch.click();
		wait.waitForPageToLoad(driver);
		return this;
	}

	public SubCategory clickOnUpdateButton() {
		updateButton.click();
		return this;
	}

	public SubCategory selectCategoryFromDropDown() {
		page.selectDropdownWithIndex(selectCategory_Update, 3);
		return this;
	}

	public SubCategory enterCategoryText() {
		subcategory_InUpdate.sendKeys(faker.generateFruitName());
		return this;

	}

	public SubCategory clickOnUpdateButtonInUpdatePage() {
		updateButton_InUpdate.click();
		return this;
	}

	public boolean isAlertUpdatedDisplayed() {
		return updatedAlert.isDisplayed();
	}
}
