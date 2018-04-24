package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Edit_Staff_Details;
import com.ScreenFunctions.Login_Admin_Logout;


public class Tc_03_Edit_Staff_Details extends GenericFunctions

{
	@Test
	public void  edit_Staff()
	{
		GenericFunctions.launchApplication("firefox");
		//enter addmin creditials
		Login_Admin_Logout la = PageFactory.initElements(driver,Login_Admin_Logout.class);
		la.login_admin();
		
		
		Edit_Staff_Details e_s_d = PageFactory.initElements(driver,Edit_Staff_Details.class);
		e_s_d.edit_staff_name();
		
	}
	
}
