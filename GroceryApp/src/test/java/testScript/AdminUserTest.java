package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminUserTest extends BaseClass {
	LoginPage login;
	HomePage page;
	AdminUserPage adminuser;

	@Test
	public void verifyToCreateNewUserwithValidDetails() throws IOException {

		login = new LoginPage(driver);
		page = login.loginByUsingExcelData();

		adminuser=page.clickonAdminUserPage().clickonNewButton().enterUserName().enterPassword().selectfromDropDown()
				.clickonSaveButton();

		boolean isAlertMessageDisplayed = adminuser.isAlertMessageDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constants.ADMINUSER_ALERT);

	}

	@Test
	public void verifyToUpdateanUserWithValidDetails() throws IOException {
		login = new LoginPage(driver);
		page = login.loginByUsingExcelData();

		adminuser=page.clickonAdminUserPage().clickonUpdateButton().changePassword().updateUserType().clickonupdateinUpdatePage();

		boolean isAlertMessageDisplayed = adminuser.updatedAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constants.ADMINUSER_ALERT);

	}
}
