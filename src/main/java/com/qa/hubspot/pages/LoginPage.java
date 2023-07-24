package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;
	//1. By locators : 
	By username= By.id("username");
	By password= By.id("password");
	By loginButton= By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	//2. constructor of the page class
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	//3. Page actions/methods:
	
	public String getLoginPagetitle() {
		
		driver.getTitle();
		return driver.getTitle();
		
		
	}
	
	public boolean checkSignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String un, String pwd) throws InterruptedException {
		
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
	Thread.sleep(5000);

	return new HomePage(driver);
}}
