package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContact;

public class ManageContactTest extends BaseClass {
	LoginPage login;
	HomePage page;
	ManageContact contact;

	@Test
	public void verifyManageContact() throws IOException {
		login = new LoginPage(driver);
		page = login.loginByUsingExcelData();

		contact=page.clickonManageContact().clickonEditButton().updateDetails().clickonupdateButton();

		boolean isAlertDisplayed = contact.isAlertMessageDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.MANA_CONTACT_ALERT);
	}
}
