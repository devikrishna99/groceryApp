package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;

public class ManageCategoryTest extends BaseClass {
	LoginPage login;
	HomePage page;
	ManageCategory category;

	@Test
	public void verifyAddNewCategorywithValidDetails() throws IOException {
		login = new LoginPage(driver);
		page = login.loginByUsingExcelData();

		category=page.clickonManageCategory().clickonNewButton().clickonInputCategory().clickonSelectGroups().uploadFile()
				.clickonSaveButton();

		boolean isAlertDisplayed = category.isalertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.MANAGECAT_ALERT);

	}
}
