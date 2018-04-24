package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Delete_Staff;
import com.ScreenFunctions.Login_Admin_Logout;

public class Tc_04_Delete_Staff extends  GenericFunctions

{

	@Test
	/* This method is used to delete record of staff*/
	
	public void delete_Staff()
	{
	
    /* Launching a firefox browser */		
		GenericFunctions.launchApplication("firefox");
		
     /* After Open webpage Login in to Admin Module */
		Login_Admin_Logout la = PageFactory.initElements(driver,Login_Admin_Logout.class);
		la.login_admin();
		
	// Now click on Delete staff
		
		Delete_Staff ds= PageFactory.initElements(driver,Delete_Staff.class);
		ds.delete_Staff();
		
	}
	
}
