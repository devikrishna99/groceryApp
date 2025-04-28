package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNews;

public class ManageNewsTest extends BaseClass {
	LoginPage login;
	HomePage page;
	ManageNews news;

	@Test
	public void verifyifWeCanEnterNew_News() throws IOException {
		login = new LoginPage(driver);
		page = login.loginByUsingExcelData();

		news=page.clickonManageNewsField().clickonNewButton().enter_newNews().clickonSaveButton();

		boolean isAlertDisplayed = news.isalertMessageDisplyed();
		Assert.assertTrue(isAlertDisplayed, Constants.MAN_NEWS_UPDATE_ALERT);

	}

	@Test
	public void verifyDeleteButton() throws IOException {
		login = new LoginPage(driver);
		page = login.loginByUsingExcelData();

		news=page.clickonManageNewsField().clickonDeleteNewsButton().accept_Alertmessage();

		boolean isAlertDisplayed = news.isdeletedAlertMessageDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.MAN_NEWSDELETE_ALERT);

	}

	@Test
	public void verifyUpdateButton() throws IOException {
		login = new LoginPage(driver);
		page = login.loginByUsingExcelData();

		news=page.clickonManageNewsField().clickonUpdateButton().updateNewsArea().clickonUpdateinUpdatePage();

		boolean isAlertDisplayed = news.isUpdatedAlertMessageDisplyed();
		Assert.assertTrue(isAlertDisplayed, Constants.MAN_NEWS_UPDATE_ALERT);

	}
}
