package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Delete_Staff extends GenericFunctions

{
	

	@FindBy(how=How.XPATH, using=("//a[text()='Delete staff']"))
	public static WebElement lnk_delete_staff;

	
	@FindBy(how=How.XPATH, using=("//input[@name='staff_id']"))
	public static WebElement rd_delete_staff;
    
    
	@FindBy(how=How.XPATH, using=("//input[@name='submit2_id'] "))
	public static WebElement btn_delete_staff;
  
    	
	@FindBy(how=How.XPATH, using=("//a[text()='Logout']"))
    public static WebElement lnk_logout_admin;

	
public static boolean delete_Staff()
{
 
	boolean status = true;

	//click on the deleted staff link
	status = hoverAndClick(lnk_delete_staff);

	System.out.println("Delete staff link is opened  for deleate a staff record");

	String str1 = getdata("Delete_Staff", "name", 1);
	String str2 = getdata("Delete_Staff", "Email", 1);
	
    status = getDeletedata(str1, str2);
	
    btn_delete_staff.click();
    System.out.println("Deleted staff record successfully");
    lnk_logout_admin.click();
  
    System.out.println("Admin logoffed successfully");

    return status;
}


}
