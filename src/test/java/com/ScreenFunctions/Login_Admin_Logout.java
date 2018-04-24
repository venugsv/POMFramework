package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;

public class Login_Admin_Logout extends GenericFunctions {

	@FindBy(how = How.XPATH, using = ("//*[text()='Admin ']"))
	public static WebElement lnk_admin;

	@FindBy(how = How.XPATH, using = ("//*[@name='uname']"))
	public static WebElement tdi_admin_username;

	@FindBy(how = How.XPATH, using = ("//*[@name='pwd']"))
	public static WebElement tdi_admin_pw;

	@FindBy(how = How.XPATH, using = ("//*[@name='submitBtn']"))
	public static WebElement btn_admin_login;
	
	@FindBy(how=How.XPATH, using=("//a[text()='Admin Home']"))
	public static WebElement lnk__admin_home;
	
	@FindBy(how=How.XPATH, using=("//a[text()='Logout']"))
	public static WebElement lnk_logout_admin;


	public static boolean login_admin() {
		boolean status = true;

		status = hoverAndClick(lnk_admin);

		
		String user = getCommontestdata("Username");
		status = setdata(tdi_admin_username, user);

		String password = getCommontestdata("Password");
		status = setdata(tdi_admin_pw, password);
		status = hoverAndClick(btn_admin_login);
		
		if(lnk__admin_home.isDisplayed())
		{
		System.out.println("Login is successfull");
		lnk_logout_admin.click();
		}
		else
		{
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			 
			System.out.println("Login is Un successfull");	
		}
		
		
		
		return status;
		
		

	}
}
