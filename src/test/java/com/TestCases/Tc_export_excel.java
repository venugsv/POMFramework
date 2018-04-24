package com.TestCases;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

@Test
public class Tc_export_excel {
	
public static void Write_excel() throws IOException
{

	WebDriver driver = new FirefoxDriver();
	driver.get("http://server/bank/index.php");
	driver.manage().window().maximize();
	
	List<WebElement>  lst = driver.findElements(By.xpath("//*[text()='Features']/preceding-sibling::p/following-sibling::ul/li"));
//	for(int i=0; i<lst.size();i++)
//	{
//	
//	System.out.println(lst.get(i).getText());
//	
//	}
//	
File f = new File("C:\\Users\\tm\\Documents\\HANDLING EXCEL.xlsx");
FileInputStream fis = new FileInputStream(f);

XSSFWorkbook wb = new XSSFWorkbook(fis);
System.out.println(wb+"Workbook");
XSSFSheet ws = wb.getSheet("Sheet2");
System.out.println(ws+"WorkSheet");
int n= lst.size();
FileOutputStream fos = new FileOutputStream(f);


for(int i=0, j=0;i<n;i++)
{
	Row row = ws.createRow(i);
	Cell c = row.createCell(j);
	c.setCellValue(lst.get(i).getText());
	wb.write(fos);
	
	
}



//lst.get(i).getText()


wb.close();
fis.close();
fos.close();





}
	
	
	
}

	

	
	

