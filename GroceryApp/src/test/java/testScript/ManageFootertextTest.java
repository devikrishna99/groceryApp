package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterText;

public class ManageFootertextTest extends BaseClass {
	LoginPage login;
	HomePage page;
	ManageFooterText footer;

	@Test
	public void verifyUpdateFooterTextInformation() throws IOException {
		login = new LoginPage(driver);
		page = login.loginByUsingExcelData();

		footer=page.clickonManageFooterText().clickonUpdateFooterText().updateDetails().clickonupdate_InFooterInfo();

		boolean isAlertMessageDisplayed = footer.alertmessageDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constants.MANAGEFOOTER_ALERT);

	}
}
