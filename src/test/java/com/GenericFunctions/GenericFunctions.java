package com.GenericFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class GenericFunctions extends TestNGListeners {
	
	
	public static  WebDriver driver;

	
	/*************************************************
	
	
	Function Name:launchApplication
	
	Purpose:-This Function is used to launch the HRM Application when ever the user is required
	
	Input Parameters:-User must send in which browser does the application need to be launch
	
	Output Parameters:-This method will return a boolean value stating wheter the user logged into in the system
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/30/2017
	
	
	**************************************************/
		
	
	public static boolean launchApplication(String browser) 
	{
		
		boolean status=true;
		
		
		switch (browser.toLowerCase()) {
		case "ie":
			
			break;

		case "firefox":
			
			driver= new FirefoxDriver();
			
			String url=getCommontestdata("Url");
			
			System.out.println(url);
			
			driver.get(url);
			
			driver.manage().window().maximize();
			
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			
			break;
			
		case "chrome":
			System. setProperty("webdriver.chrome.driver", "C:\\Users\\tm\\Downloads\\chromedriver.exe");		
			
			driver =new ChromeDriver();
			String url1=getCommontestdata("Url");
			System.out.println(url1);
			driver.manage().window().maximize();

			break;
			
			
			
		default:
			break;
		}
		
	return status;	
		
	}
	

	/*************************************************
	
	
	Function Name:GetCommonTestdata 
	
	Purpose:-This Function is used to get the common test data which can be accessed commonly for each testcase such as Environment,Url,Username,Password
	
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/31/2017
	
	
	**************************************************/
	
	
	
	public static String getCommontestdata(String data)
	{
		
		String strQuery="Select "+ data+" from CommonTestdata";
		
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(data));
				
				fetcheddata=recordset.getField(data);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
/*************************************************
	
	
	Function Name: setdata
	
	Purpose:-This Function is used to get the common test data which can be accessed commonly for each testcase such as Environment,Url,Username,Password
	
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/31/2017
	
	
	**************************************************/	
	
	
	
	
	
    public static boolean setdata(WebElement element, String data)
    {
	
	boolean status = true;
	status = waitForElement(element);
	
	if(status)
	{
	
	
	try {
		element.click();
		element.clear();
		element.sendKeys(data);
	}
	
	catch(Exception e)
	{
	
		System.out.println("element not found");
		
		
	}}
	else
	{
		System.out.println("element is not found to do action");
	}
	
	
	return status;
	
	
		
    }
	


   /*************************************************


Function Name: getdata

Purpose:-This Function is used to get the common test data which can be accessed commonly for each testcase such as Environment,Url,Username,Password

Input Parameters:-User must send an argument stating what data that is required

Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)

Author:-Veera Prathap Malepati

Creationn date:-12/31/2017


**************************************************/	

	
	public static String getdata(String sheetname,String userdata,int itr)
	{
		
		String strQuery="Select "+ userdata+" from "+sheetname+ " where Tc_Name='"+crntclass+"' and Iteration="+itr;
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(userdata));
				
				fetcheddata=recordset.getField(userdata);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
/*************************************************
	
	
	Function Name: waitForElement
	
	Purpose:-This Function is used to wait for the webelement until element found otherwise raise a exception	
	
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/31/2017
	
	
	**************************************************/	
	
	
	
	public static boolean waitForElement(WebElement element)
	{
	
		boolean status = true;
		for(int i=1;i<=10;i++)
		{
		try
		{
			System.out.println("Wait is executing");
			Actions acc=new Actions(driver);
			acc.moveToElement(element).build().perform();
			
			System.out.println("Element Found");
			break;
			
		}
		catch(Exception e)
		{
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			
		}
		}	
	
		return status;
	}
	
	
	
/*************************************************
	
	
	Function Name: hoverAndClick
	
	Purpose:-This Function is used to get the common test data which can be accessed commonly for each testcase such as Environment,Url,Username,Password
	
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/31/2017
	
	
	**************************************************/	
	
	public static boolean hoverAndClick(WebElement element)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			Actions acc=new Actions(driver);
			acc.moveToElement(element).click().build().perform();
		
		
			
			
		}
		catch(Exception e)
		{
			
			status=false;
		
		}	
		
	
	
	return status;
	}	
	
	public static void forceClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", element);
		
	}

/*************************************************
	
	
	Function Name: selectOption
	
	Purpose:-This Function is used to get dynamic data from list box.
		
	Input Parameters:-User must pass an webelement(list or dropdown) and string value
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Venu
	
	Creation date:-06/04/2018
	
	
	**************************************************/	


  public static boolean selectOption(WebElement lstelement, String optiondata)
  {
	boolean status = true;
	
	try 
	{
		
		Select sc = new Select(lstelement);
		sc.selectByVisibleText(optiondata);
	
		System.out.println("option"+optiondata+" is selected success for the element"+lstelement);
		
		
	}
	catch (Exception e)
	{
	
		 status = false;
		 System.out.println("Unable to select option"+optiondata+" for the element"+lstelement);
	}
	
	
	return status;
   }

/*************************************************
	
	
	Function Name: getDeletedata
	
	Purpose:-This Function is used to delete dynamic data from a table.
		
	Input Parameters:-User must pass two arguments(staffname and email id(unique) to idenify the row which want to delete
	
	Output Parameters:-This method will return a boolean value for the User given input	
	
	Author:-Venu
	
	Creation date:-06/04/2018
	
	
	**************************************************/	
  
  
  public static boolean getDeletedata(String name, String email)
  {
	  
	  boolean status = true;
	  
	  WebElement wb = driver.findElement(By.xpath("//td[text()='"+ name +"']/following-sibling::td[8]/preceding-sibling::td[9]"));
	  status = hoverAndClick(wb);
	  if(status)
		  System.out.println("Radio button seleted for delete particular record");
	  else
		  System.out.println("Radio button not seleted for delete particular record");
	  
	  
	  
	  return status;
	  
  }
  
  
  
}

 

