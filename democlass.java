package com.mavendemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class democlass {

	public static void main(String[] args) throws IOException {
	      System.setProperty("webdriver.chrome.driver","C:\\Users\\ZP351ZX\\OneDrive - EY\\Desktop\\Selenium\\new version\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
	     driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	      driver.manage().timeouts().implicitlyWait(49, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      
	      // Download POI jar for selenium
	      
	      File path=new File("C:\\Users\\ZP351ZX\\OneDrive - EY\\Desktop\\Automation Testing\\Book1.xlsx");
	      FileInputStream is=new FileInputStream(path);
	      XSSFWorkbook wb=new XSSFWorkbook(is);   
	      XSSFSheet sheet = wb.getSheet("Credentials");  //tab name in excel
	      
	      XSSFRow r = sheet.getRow(1);
	      XSSFCell c = r.getCell(1);
	      String Password = c.getStringCellValue();
	      System.out.println(Password);
	      
	      XSSFRow r1 = sheet.getRow(1);
	      XSSFCell c1 = r1.getCell(0);
	      String Username = c1.getStringCellValue();
	      System.out.println(Username);
	      
	      driver.findElement(By.xpath("//input[@id='login1']")).sendKeys(Username);
	      driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
	      driver.findElement(By.xpath("//input[@name='proceed']")).click();    
	      
	      

	}

}
