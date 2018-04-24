package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Add_Customer;
import com.ScreenFunctions.Login_Admin_Logout;

public class Tc_02_Add_Customer extends GenericFunctions 
{
	@Test
    public static void add_Customer1()
    {
	GenericFunctions.launchApplication("firefox");
	//enter addmin creditials
	Login_Admin_Logout la = PageFactory.initElements(driver,Login_Admin_Logout.class);
	la.login_admin();
	
	Add_Customer addcus = PageFactory.initElements(driver,Add_Customer.class);
	addcus.add_Customer();
	//Now 
	
	
    }
	
}
