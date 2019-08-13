package web_pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {

	WebDriver chrome;
	
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement login_link;
	
	@FindBy(xpath="//a[@href='/customer/info']")
	WebElement customer_info;
	
	@FindBy(xpath="//a[@href='/logout']")
	WebElement logout_link;
	
	@FindBy(xpath="//a[@href='/register']")
	WebElement register_link;
	
	
	
	
	public Home_page(WebDriver chrome2) {
		this.chrome=chrome2;
		PageFactory.initElements(chrome, this);
	}
	
	
	public String verify_title() {
		String title=chrome.getTitle();
		System.out.println(title +"found");
		return title;
	}
	
	public boolean verify_register_text(Logger log) {
		String reg=register_link.getText();
		if(reg.equalsIgnoreCase("Register")) {
			log.info("Register Link in home page Verification");
			return true;
		}
		else {
			log.info("Login Link Missing");
			return false;
		}
	}
	
	
	public boolean verify_login_text(Logger log2) {
		
		String log=login_link.getText();
		if(log.equalsIgnoreCase("Log in")) {
			log2.info("Login Link in home page Verification");
			return true;
		}
		else {
			log2.info("Login Link Missing");
			return false;
		}
	}
	
	public void click_login() {
		System.out.println("Login Link clicked");
		login_link.click();
	}
	
	public boolean verify_email(String email, Logger log) {
		String info=customer_info.getText();
		if(info.equalsIgnoreCase(email)) {
			log.info("Login is successful");
			
			return true;
		}
		else {
			log.info("Login was unsuccessful");
			
			return false;
		}
	}
	
	public void go_to_profile() {
		System.out.println(customer_info.getText());
		customer_info.click();
	}

}
