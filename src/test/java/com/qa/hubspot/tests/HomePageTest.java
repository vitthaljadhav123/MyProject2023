package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.UitilsPackage.Constacts;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {

	Properties prop;
	BasePage basePage;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	@BeforeTest
	public void setup() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_prop();	
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(7000);
	}
	
	@Test(priority=1)
	
	public void VerifyHomePageTitleTest() throws InterruptedException {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is : "+ title );
		Assert.assertEquals(title , Constacts.HOME_PAGE_TITLE);
	}
	
	@Test
	public void VerifyHomePageHeader() {
		String header = homePage.getHomepageHeader();
		System.out.println("Home page header : " + header);
		Assert.assertEquals(header, Constacts.HOME_PAGE_HEADER);
	}
	
	@Test
	public void verigyLoggedInUserTest() {
		
		String accountName = homePage.getAccountName();
		System.out.println("logged account name is : "+ accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountName"));
	}
	
	
	
	
	
	
     @AfterTest
	
	public void tearDown() {
		
		driver.quit();
	}
}
