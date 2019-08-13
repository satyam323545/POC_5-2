package web_pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_page {

WebDriver chrome;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement textbox_email;
	
	public Account_page(WebDriver chrome2) {
		this.chrome=chrome2;
	}
	
	public boolean verify_title(Logger log) {
		String title=chrome.getTitle();
		if(title.equalsIgnoreCase("Demo Web Shop. Account")) {
			log.info(title+" found");
			
			return true;
		}
		else {
			log.info(title+"Not found");
			
			return false;
		}
	}
	
	public boolean verify_email(String email, Logger log) {
		String data=textbox_email.getText();
		if(data.equalsIgnoreCase(email)) {
			log.info(email+" found");
			
			return true;
		}
		else {
			log.info(email+" not found ");
			
			return false;
		}
		
	}
	

}
