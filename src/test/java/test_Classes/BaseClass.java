package test_Classes;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POM_UtilityPckg.ExplicitWait_WebEle;
import pom_Packg.LogIn_Page;
import test_Utility.Browser_Launch;
import test_Utility.ImplicitWait_Webpage;
import test_Utility.Screenshot_Proof;

public class BaseClass
{
	
	public static ExtentReports report;//location of the report 
	public static ExtentHtmlReporter extent;//ref 
	public static ExtentTest logger;

	LogIn_Page login;
	static WebDriver driver;

	@Parameters({ "browsernm"})//common/repeatative value will be use then use parameter just give name n value in testng.xml
	@BeforeTest
    public static void BeforeTest(String browsernm) 
	{
		  
		 driver=Browser_Launch.Open_Browser(browsernm,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//this.driver=driver;
		 ImplicitWait_Webpage .implicit_Wait(driver,10);
		
		
		extent=new  ExtentHtmlReporter("test-output"+File.separator+"Report"+File.separator+System.currentTimeMillis()+".html");
		report=new ExtentReports();
		 report.attachReporter(extent);

		 report.setSystemInfo("User_Id","Prajakta Sagane");
		report.setSystemInfo("OS", "windows11");
	report.setSystemInfo("Enviroment","SIT");
		
		
		 
	}
	
	//  
	
	
	
	@AfterTest
	public void afterTest()
	{
	
	driver.close();
	}
   
	@AfterMethod 
	public  void afterMethod(ITestResult result)throws IOException, InterruptedException
	{ //listener class methods are automaticaaly invoked whenever testcase is pass failed or skip
		/*TestNG provides the @Listeners annotation which listens to every event that occurs in a selenium code. Listeners are activated either before the test or after the test case. 
		 * It is an interface that modifies the TestNG behavior.
		 * Listener is defined as interface that modifies the default TestNG’s behavior. As the name suggests Listeners “listen” to the event defined in the selenium script and behave accordingly. It is used in selenium by implementing Listeners Interface. It allows customizing TestNG reports or logs. There are many types of TestNG listeners available.
 'ITestResult' is an interface that describes the result of the test. 
 Therefore 'result' has been passed as its instance in the syntax. 
*/
		Thread.sleep(1000);
	/*	if(result.getStatus()==ITestResult.CREATED)//
		{
			logger.createNode("Testcase is successfully Created");
			
		}*/
		 if(result.getStatus()==ITestResult.FAILURE)
		{
			
			String path=Screenshot_Proof.screen_shot(driver);
			logger.fail("Test case is failed",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		    
		}
	
		/*else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("test case is skipped");
		}*/
		
		
		
		/*else if(result.getStatus()==ITestResult.SUCCESS)//pass testcase(
		{
			String path=Screenshot_Proof.screen_shot(driver);
						logger.pass("Test case is successfully passed",MediaEntityBuilder.createScreenCaptureFromPath(path,"PassTestCase").build());
		}*/
		 
		 report.flush();
		
		// Thread.sleep(500);
		// login=new LogIn_Page (driver);
		// String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		
		// ExplicitWait_WebEle.Explicit_wait(driver, 10, "//input[@placeholder='Username']");
		/* Thread.sleep(500);
		 login.clear_Username();
			Thread.sleep(500);
			login.clear_Password();*/
		}
		
		
		
	}
	
	
	

/*@Parameters: This @Parameters annotation is used to pass parameters to a test method. The values of parameters are provided using the testng.xml file at runtime.

This parameter annotation can be used with any of the Before/After, Factory, Test annotated methods.
Data driven :- pass data through xml file,testng.xml by using parameters also   
@Listeners: This annotation is defined as an array of test listeners classes that extends org.testng.ITestNGListener. 
It is used to track the execution status and to customize TestNG reports or logs.
*/
