package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Login_Admin_Logout;

@Test

public class Tc_01_Login_Admin extends GenericFunctions
{

	public static void login_Admin()
	{
		
		GenericFunctions.launchApplication("firefox");
		
		Login_Admin_Logout la = PageFactory.initElements(driver,Login_Admin_Logout.class);
		
		la.login_admin();
		
	}
	
	
	
	
}
