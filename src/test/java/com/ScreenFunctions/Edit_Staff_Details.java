package com.ScreenFunctions;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Edit_Staff_Details extends GenericFunctions
{

	@FindBy(how=How.XPATH, using=("//a[text()='Edit staff member']"))
	
	public static WebElement lnk_edit_staff1;
	
	
@FindBy(how=How.XPATH, using=("//input[@name='staff_id']"))
	
	public static WebElement rd_edit_staff;



@FindBy(how=How.XPATH, using=("//input[@name='submit1_id']"))

public static WebElement btn_edit_staffdetails;



@FindBy(how=How.XPATH, using=("//input[@name='edit_name']"))

public static WebElement tdi_edit_staff_name;


@FindBy(how=How.XPATH, using=("//input[@name='alter']"))

public static WebElement btn_update_staff_name;


@FindBy(how=How.XPATH, using=("//a[text()='Logout']"))

public static WebElement lnk_logout_admin;


public static boolean edit_staff_name()
{
boolean status =true;

//click on the edit staff link
status = hoverAndClick(lnk_edit_staff1);

System.out.println("edit staff link is opened a edit staff page");

//Click on the radio button which you want edit the staff name

rd_edit_staff.click();
//Click on edit staff details button
btn_edit_staffdetails.click();

//get the staff name which want to update

String sname= getdata("Edit_Staff_Name" ,"Staffname", 1 );
status=setdata(tdi_edit_staff_name,sname);

btn_update_staff_name.click();
if(status)

	System.out.println("Updated Staff name");
	else
		
		System.out.println("Not Updated Staff name");


lnk_logout_admin.click();
System.out.println("Admin logoffed successfully");
return status;
	
}




}
	

