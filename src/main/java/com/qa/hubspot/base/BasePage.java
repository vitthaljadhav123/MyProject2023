package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.util.TimeUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	
	/**
	 * This method is used to init the driver on the basis on given browser 
	 * @param browser
	 * @return
	 * @throws InterruptedException 
	 */
	public WebDriver init_driver(Properties prop) throws InterruptedException {
		
		
		String browser = prop.getProperty("browser");
		System.out.println("Browser name is : "+ browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
			
			else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver= new ChromeDriver();
		}
		
		driver.get(prop.getProperty("url"));
	
	
		TimeUtils.MediumWait();
			
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		
		
		return driver;
		
				
		}
	
	/**
	 * This method is used to init/load the properties from config file 
	 * @return prop 
	 */
	
	public Properties init_prop()  {
		prop = new Properties();
		try {
			FileInputStream ip= new FileInputStream("./src/main/java/com/qa/hubspit/config/config.properties");
		    prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
	    }
		
		return prop;
		
	}
	
	}
	

