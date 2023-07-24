package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.UitilsPackage.Constacts;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest {

	//Pre condition --> Test -->ac vs expected --.post step
	//@Beforetest --> @Test --> Assert --> @AfterTest
	//browser, url --> test google title --> Google vs Google --> close browser
	Properties prop;
	BasePage basePage;
	WebDriver driver;
	LoginPage loginPage;
	@BeforeTest
	public void setup() throws InterruptedException {
		basePage = new BasePage();
		
		prop = basePage.init_prop();	
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		
	}
	
	@Test (priority=1)
	public void verifyLoginPageTitleTest() {
		
		String title = loginPage.getLoginPagetitle();
		System.out.println("Login page title is : "+ title);
		
		Assert.assertEquals(title, Constacts.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	
	public void verifySignUpLink() {
		Assert.assertTrue(loginPage.checkSignUpLink());
	}
	
	@Test(priority=3)
	
	public void loginPage() throws InterruptedException {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
