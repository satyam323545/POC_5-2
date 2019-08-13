package testNG_tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import web_pages.Account_page;
import web_pages.Home_page;
import web_pages.Login_page;
import utilities.*;

public class Profile_page_actions extends Login_n_Homepage_actions{
	
	Account_page account_page;
	Login_page login_page;
	Home_page home_page;
	String email,password;
	Excel_manipulation m=new Excel_manipulation();
	
	public Profile_page_actions(String email, String password) {
		// TODO Auto-generated constructor stub
		this.email=email;
		this.password=password;
	}

	@Test(priority=45)
	  public void do_login() {
		login_page=new Login_page(chrome);
		home_page=new Home_page(chrome);
		System.out.println(email);
		login_page.add_data(email, password);
		  login_page.click_login();
		  
		  boolean customer_verify=home_page.verify_email(email,log);
		  Assert.assertEquals(customer_verify, true);
		  
	  }
	
	//@Test(priority=46)
	public void profile(){
		account_page=new Account_page(chrome);
		home_page.go_to_profile();
		

		boolean customer_verify=account_page.verify_title(log);
		Assert.assertEquals(customer_verify, true);
		
		
	}
	
	//@Test(priority=47)
	public void mail_verification() {
		boolean k=account_page.verify_email(email,log);
		Assert.assertEquals(k, true);
	}
	
}
