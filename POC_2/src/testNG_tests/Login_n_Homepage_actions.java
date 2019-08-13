package testNG_tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import web_pages.Home_page;
import web_pages.Login_page;

public class Login_n_Homepage_actions {
	WebDriver chrome;
	  Home_page home_page;
	  Login_page login_page;
	  WebDriverWait wait;
	  Logger log;
	  
		
	  @BeforeClass
	  public void launchbrowser() {
		  log=Logger.getLogger("devpinoyLogger");
		  
		  System.setProperty("webdriver.chrome.driver", "chromedriver_version_75.exe");
			chrome=new ChromeDriver();
			chrome.get("http://demowebshop.tricentis.com/");
			wait=new WebDriverWait(chrome, 5);
			log.info("Browser Launched");
			
			
	  }
	  
	  
	  
	  
	  @Test(priority=1)
	  public void login_text_verify() {
		  home_page=new Home_page(chrome);
		  boolean verify=home_page.verify_login_text(log);
		  Assert.assertEquals(verify, true);
		  log.info("Login Link is present");
		  
	  }
	  
	  @Test(priority=2)
	  public void register_text_verify() {
		  boolean verify=home_page.verify_register_text(log);
		  Assert.assertEquals(verify, true);
		  
		  
	  }
	  
	  @Test(priority=3)
	  public void go_to_login() {
		  login_page=new Login_page(chrome);
		  home_page.click_login();
		  boolean verify=login_page.verify_title(log);
		  Assert.assertEquals(verify, true);
		  
		  
	  }
	  
	  
	  

}
