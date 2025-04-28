package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	LoginPage login;

	@Test
	public void verifyUserloginwithValidCredentials() throws IOException {
		login = new LoginPage(driver);
		login.loginByUsingExcelData();

		boolean ishomepageLoaded = login.ishomePageLoded();
		Assert.assertTrue(ishomepageLoaded, Constants.LP_VERIFYLOGINWITHVALIDCEDENTIALS);
	}

	@Test
	public void verifyUserloginwithInValidUsernameandValidPassword() {
		login = new LoginPage(driver);
		login.enterUsernameonUsernameField("admin12").enterPasswordOnpasswordField("admin").signinButtonClick();
		
		boolean alertmessagedisplayed = login.alerMessageBox();
		Assert.assertTrue(alertmessagedisplayed, Constants.LP_VERIFYLOGINWITHINVALIDCREDENTIALS);
	}

	@Test(dataProvider = "dpmethod")
	public void verifyUserloginwithValidUsernameandInValidPassword(String username, String password) {
		login = new LoginPage(driver);
		login.enterUsernameonUsernameField(username).enterPasswordOnpasswordField(password).signinButtonClick();
		
		boolean alertmessagedisplayed = login.alerMessageBox();
		Assert.assertTrue(alertmessagedisplayed, Constants.LP_VERIFYLOGINWITHINVALIDCREDENTIALS);
	}

	@DataProvider
	public Object[][] dpmethod() {
		return new Object[][] { { "admin", "1q2w3e4r" }, { "admin", "12345" } };
	}

	@Test
	public void verifyUserLoginwithInvalidCredentials() {
		login = new LoginPage(driver);
		login.enterUsernameonUsernameField("adding").enterPasswordOnpasswordField("1234").signinButtonClick();
		
		boolean alertmessagedisplayed = login.alerMessageBox();
		Assert.assertTrue(alertmessagedisplayed, Constants.LP_VERIFYLOGINWITHINVALIDCREDENTIALS);
	}

}
