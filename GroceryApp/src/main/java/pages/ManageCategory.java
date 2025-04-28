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

public class ManageCategory {
	
	public WebDriver driver;
	 Pageutility page =new Pageutility();
	 FileupLoadUtility upload = new FileupLoadUtility();
	 WaitUtilities wait= new WaitUtilities();
	 FakerUtility faker = new FakerUtility();
	
	 
	 public ManageCategory(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);

	 }
	 @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")WebElement newButton;
	 @FindBy(xpath="//input[@class='form-control']") WebElement inputCategory;
	 @FindBy(xpath="//div[@class='ms-selectable']")WebElement leftBoxContainer;
	 @FindBy(xpath="//div[@class='ms-selection']")WebElement rightBoxContainer;
	 @FindBy(xpath="//li[@id='134-selectable']")WebElement selectGroupsLeft;
	 @FindBy(xpath="//li[@id='134-selection']")WebElement selectGroupsRight;
	 @FindBy(xpath="//input[@name='main_img']")WebElement chooseFile;
	 @FindBy(xpath="//button[@class='btn btn-danger']")WebElement saveButton;
	 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertDisplay;
	 
	 public ManageCategory clickonNewButton() {
		 newButton.click();
		 return this;
	 }
	 public ManageCategory clickonInputCategory() {
		 inputCategory.sendKeys(faker.generatefoodname());
		 return this;
	 }
	 public ManageCategory clickonSelectGroups() {
		 if (leftBoxContainer.getText().contains("discount")) {
			 selectGroupsLeft.click();
		 }
		 else if(rightBoxContainer.getText().contains("discount")) {
			 selectGroupsRight.click();
			 
		 }
		 
		 return this;
	 }
	 public ManageCategory uploadFile() {
		 String filepath = Constants.MANAGECAT_UPLOADIMAGE;
		 upload.fileUpload_sendkeys(chooseFile, filepath);
		
		 return this;
		 
	 }
	 public ManageCategory clickonSaveButton() {
		wait.waitForElementTobeClicable(driver, saveButton);
		page.clickJavaScriptExecutor(saveButton, driver);
		
		return this;
	 }
	 
	 public boolean isalertDisplayed() {
		 return alertDisplay.isDisplayed();
	 }

}
