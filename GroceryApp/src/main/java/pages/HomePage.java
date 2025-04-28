package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a [@href ='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	WebElement subcategoryButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class ='small-box-footer']")
	WebElement manageContactButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement manageNewsField;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement manageFooterText;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement manageCategory;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement adminUserPage;

	public SubCategory clickOnSubcategory() {
		subcategoryButton.click();
		return new SubCategory(driver);
	}

	public ManageContact clickonManageContact() {
		manageContactButton.click();
		return new ManageContact(driver);
	}

	public ManageNews clickonManageNewsField() {
		manageNewsField.click();
		return new ManageNews(driver);
	}

	public ManageFooterText clickonManageFooterText() {
		manageFooterText.click();
		return new ManageFooterText(driver);
	}

	public ManageCategory clickonManageCategory() {
		manageCategory.click();
		return new ManageCategory(driver);
	}

	public AdminUserPage clickonAdminUserPage() {
		adminUserPage.click();
		return new AdminUserPage(driver);
	}

}
