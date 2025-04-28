package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategory;

public class SubCategoryTest extends BaseClass {
	LoginPage login;
	HomePage page;
	SubCategory subcategory;

	@Test(groups="smoke")
	public void verifyAddNewSubCategorywithValidDetails() throws IOException {
		login = new LoginPage(driver);
		page=login.loginByUsingExcelData();

		subcategory = page.clickOnSubcategory().clickOnNewButton().selectCategory().enterSubcategory().uploadImage()
				.clickOnsaveButton();

		boolean isAlertDisplayed = subcategory.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.SUBCAT_ALERT);

	}

	@Test
	public void verifyUpdateButtonwithValidDetails() throws IOException {
		login = new LoginPage(driver);
		page=login.loginByUsingExcelData();
		
		subcategory=page.clickOnSubcategory().clickOnUpdateButton().selectCategoryFromDropDown().enterCategoryText().clickOnUpdateButtonInUpdatePage();
		
		boolean isAlertDisplayed = subcategory.isAlertUpdatedDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.SUBCAT_UPDATEALERT);
		
	}
}
