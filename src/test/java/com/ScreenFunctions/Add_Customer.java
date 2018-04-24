package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Add_Customer extends GenericFunctions {

	//find out link for Add customer
	@FindBy(how = How.XPATH, using = ("//a[text()='Add Customer']"))
	public static WebElement lnk_add_customer;
	
	//find out textbox for customer name
	@FindBy(how = How.XPATH, using = ("//*[@name='customer_name']"))
	public static WebElement tdi_uname;

	//find out radiobutton for gender
	@FindBy(how = How.XPATH, using = ("//*[@name='customer_gender'][1]"))
	public static WebElement rd_gender;

	//find out radiobutton for gender
	@FindBy(how = How.XPATH, using = ("//input[@name='customer_dob']"))
	public static WebElement tdi_dob;
	
	//find out textbox for customer nominee 
	@FindBy(how = How.XPATH, using = ("//input[@name='customer_nominee']"))
	public static WebElement tdi_c_nominee;

	//find out select option for branch 
	@FindBy(how = How.XPATH, using = ("//select[@name='branch']/option"))
	public static WebElement lst_branch;
    
	//find out select option for account type
	@FindBy(how = How.XPATH, using = ("//select[@name='customer_account']/option"))
	public static WebElement lst_ac_type;

	//find out textbox for minimum balance
	@FindBy(how = How.XPATH, using = ("//input[@name='initial']"))
	public static WebElement tdi_mini_amount;

	//find out textbox for customer address 
	@FindBy(how = How.XPATH, using = ("//*[@name='customer_address']"))
	public static WebElement tdi_address;
    
	//find out textbox for minimum balance
	@FindBy(how = How.XPATH, using = ("//*[@name='customer_mobile']"))
	public static WebElement tdi_mobile;
    
	//find out textbox for minimum balance
	@FindBy(how = How.XPATH, using = ("//*[@name='customer_email']"))
	public static WebElement tdi_email;

	@FindBy(how = How.XPATH, using = ("//*[@name='customer_pwd']"))
	public static WebElement tdi_c_pwd;

	@FindBy(how = How.XPATH, using = ("//*[@name='add_customer']"))
	public static WebElement btn_add_customer;

	@FindBy(how=How.XPATH, using=("//a[text()='Logout']"))
	public static WebElement lnk_logout_admin;

	
	
	public static boolean add_Customer()
	{

		boolean status = true;

		// click on the add customer link
		status = hoverAndClick(lnk_add_customer);

		System.out.println("add customer link is opened a customer page");

		// get the customer name from test data sheet

		String cname = getdata("AddCustomerInfo", "Customername", 1);
		status = setdata(tdi_uname, cname);

		String cdob = getdata("AddCustomerInfo", "DOB", 1);
		status = setdata(tdi_dob, cdob);

		String cNominee = getdata("AddCustomerInfo", "Nominee", 1);
		status = setdata(tdi_c_nominee, cNominee);

		String cmim = getdata("AddCustomerInfo", "Minimum", 1);
		status = setdata(tdi_mini_amount, cmim);

		String cAddress = getdata("AddCustomerInfo", "Address", 1);
		status = setdata(tdi_address, cAddress);

		String cMobile = getdata("AddCustomerInfo", "Mobile", 1);
		status = setdata(tdi_mobile, cMobile);

		String cEmail_id = getdata("AddCustomerInfo", "Email_id", 1);
		status = setdata(tdi_email, cEmail_id);

		String cPassword = getdata("AddCustomerInfo", "Password", 1);
		status = setdata(tdi_c_pwd, cPassword);

		// click on add customer button

		status = hoverAndClick(btn_add_customer);
		
		lnk_logout_admin.click();
		return status;

	}

}
