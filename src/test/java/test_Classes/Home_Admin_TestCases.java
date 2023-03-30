package test_Classes;

import org.testng.Assert;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_UtilityPckg.ExplicitWait_WebEle;
import pom_Packg.Home_Admin_Page;
import pom_Packg.LogIn_Page;
import test_Utility.ReadFileData;

public class Home_Admin_TestCases extends BaseClass
{

Home_Admin_Page homeadm;
LogIn_Page login;
ReadFileData r;

@BeforeClass                         //used to execute method before executing testclass
public  void beforeClass()
{
	
	//obj of LogIn_Page pomclass
	homeadm=new Home_Admin_Page(driver);
}

@BeforeMethod()              //used to execute method before executing every testmethod declared with @ test annotation
public  void beforeMethod() throws EncryptedDocumentException, IOException, InterruptedException
{
	login=new LogIn_Page (driver);
	Thread.sleep(500);
    login.clear_Username();
	Thread.sleep(500);
	login.clear_Password();
	
	ExplicitWait_WebEle.Explicit_wait(driver, 10, "//input[@placeholder='Username']");
	
	login.enter_Username(r.fetchDataFromExcel (1,0));
	
	
	login.enter_Password(r.fetchDataFromExcel (1,1));
	Thread.sleep(500);
	login.clickOn_LogInBtn();
 
	
}

@Test
public void verifyAdminTab() throws EncryptedDocumentException, IOException, InterruptedException
{
	
	logger=report.createTest(" Verify Admin Tab");
	//homeadm.click_Admin();
	 
	String actualUrl=driver.getCurrentUrl();
	String expectedUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	SoftAssert s=new SoftAssert();
	Thread.sleep(5000);
	s.assertEquals(actualUrl, expectedUrl);
	s.assertAll();
	//Assert.assertEquals(actualUrl, expectedUrl);
	//Assert.fail();
	//homeadm.click_Admin();
	
}



}