package web_pages;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testNG_tests.Login_n_Homepage_actions;
public class Login_page {

	WebDriverWait wait;
	WebDriver chrome;
	
	Login_n_Homepage_actions ac=new Login_n_Homepage_actions();
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement passwrd;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement button_login;
	
	public Login_page(WebDriver chrome2) {
		this.chrome=chrome2;
		PageFactory.initElements(chrome, this);
	}
	
	public boolean verify_title(Logger log) {
		String title=chrome.getTitle();
		if(title.equalsIgnoreCase("Demo Web Shop. Login")) {
			log.info("Title verified: "+ title);
			return true;
		}
		else {
			log.info("Title verify failed: "+ title);
			return false;
		}
	}
	
	public void add_data(String username, String password) {
		
		chrome.findElement(By.xpath("//input[@id='Email']")).sendKeys(username);
		chrome.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		System.out.println("Data Input done");
	}
	
	public void click_login() {
		chrome.findElement(By.xpath("//input[@value='Log in']")).click();
		System.out.println("Login Input Button Clicked");
	}

}
