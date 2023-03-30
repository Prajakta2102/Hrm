package test_Classes;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;//hard Assert
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;//SoftAssert

import pom_Packg.LogIn_Page;
import test_Utility.ImplicitWait_Webpage;
import test_Utility.ReadFileData;
import test_Utility.Screenshot_Proof;


public class LogInTestCases extends BaseClass
{

LogIn_Page login;
//globally  declared
ReadFileData r;

/* annotations are work as  main method so we dont need main method.*/
@BeforeClass                         //used to execute method before executing testclass
public  void beforeClass()
{
	
	//login=new LogIn_Page (driver);//obj of LogIn_Page pomclass
	
}

@BeforeMethod()              //used to execute method before executing every testmethod declared with @ test annotation
public  void beforeMethod() throws InterruptedException
{
	
	
	System.out.println("beforeMethod of Class");
	//System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driver\\chromedriver.exe");
	/*WebDriver driver=new ChromeDriver();

	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/
	 login=new LogIn_Page (driver);
	 Thread.sleep(500);
	 login.clear_Username();
		Thread.sleep(500);
		login.clear_Password();
	 
}


@Test (priority=1)//,dependsOnMethods= {"VerifyLoginFunctionalityWithInvalidData"})                    //used to execute the actual testcase(using hard assert)
public void VerifyLoginFunctionalityWithvalidData()throws IOException,InterruptedException
{
	
	logger=report.createTest(" Verify Login Functionality With valid Data");
	login.enter_Username(r.fetchDataFromExcel (1,0));
	
	//Thread.sleep(500);
	login.enter_Password(r.fetchDataFromExcel (1,1));
	boolean result=login.toVerifyLogInButton();
	 
	Assert.assertTrue(true);//1
	
	
	Assert.fail();
	
 
    
    System.out.println("login button is visible");//2
	
	String actual=login.toGetLogInButtonText();
	String expected="Login";
	
	Thread.sleep(1000);
	 String ExpectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";//3
    String CurrentURL=driver.getCurrentUrl();
    
    Assert.assertEquals(actual, expected);
   
    System.out.println(actual);//3
    //Thread.sleep(500);
     login.clickOn_LogInBtn();
   Assert.assertEquals(CurrentURL, ExpectedURL);//4
  //  Assert.fail(); 
  
    //login.screen_shot(driver,"date");
    //String ResultMsg="Tetscase_passed";
     
   // Hard Assert-->Static methods of assert class
    // Assert.assertNotEquals(CurrentURL, ExpectedURL,"ResultMsg");
    
   // Assert.assertFalse(false);
   // Assert.fail();direct failed the Testcase
    
     //SoftAssert-->non Static methods of SoftAssert class
      //SoftAssert s=new SoftAssert();
      
      //obj of SoftAssert class
    //  s.assertEquals(CurrentURL, ExpectedURL);
      
    //  s.assertAll("ResultMsg");
     // System.out.println(ResultMsg);
     /*s.assertNotEquals(CurrentURL, ExpectedURL);
    s.assertTrue(true);//return boolean val
    s.assertFalse(false);
    s.assertAll();*/
}
//using SoftAssert methods

@Test(priority=2)
public void VerifyLoginFunctionalityWithInvalidData()throws IOException,InterruptedException
{
	logger=report.createTest(" Verify Login Functionality With invalid Data");
//	login.enter_Username("Admin");
//login.enter_Password("admin1234");
	login.enter_Username(r.fetchDataFromExcel (3,0));
	//Thread.sleep(500);
	login.enter_Password(r.fetchDataFromExcel (3,1));
	//Screenshot_Proof.screen_shot(driver,"date");
	//String ExpectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";//valid url
	 String ExpectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";//invalid url
	String ActualURL=login.toCheckActualURL();
	//String ActualURL=driver.getCurrentUrl();
	//login.screen_shot(driver,"date");
	System.out.println(driver.getCurrentUrl());//1
	SoftAssert s=new SoftAssert();
	 s.assertNotEquals(ActualURL, ExpectedURL);//2//pass
	String  ExpectedTitle="OrangeHRm";
	String ActualTitle=login.toVerifyTitleOfPage();
	//Thread.sleep(500);
	s.assertNotEquals(ActualTitle, ExpectedTitle);//3
	System.out.println(ActualTitle);//4
	
	boolean loginbutton=login.toVerifyLogInButton();
	s.assertTrue(true);//5
	//Thread.sleep(500);
	s.assertAll();//6
	
	Thread.sleep(500);
	
}


/*@AfterMethod()     //used to execute method after executing every testmethod declared with @ test annotation
public void afterMethod()
{
	//System.out.println("afterMethod of Class");
	driver.quit();
}
/*
@AfterClass     ///used to execute method after execution of testclass.
public void afterClass()
{
	driver.close();
}*/
}






















/*ASSERTION:-
 * whether test is failed or passed.it is successful if it execute  without throwing an exception 
 * HARD ASSERT:
 * (if one of testcase is failed then it will not excute the testcase after that testcase.)
    
 *  if testcase contain multiple testmethod and any particular testmethod fails at points.
 *  then next steps will not get executed.
 *  testng will mark that testcase as failed and it will executed rest of testcases
 *  Assert is class nd all method are static and overloaded wid different arg...so cl wid classname
 *   //Assert.assertEquals(CurrentURL, ExpectedURL); 
   // Hard Assert-->Static methods of assert class
    // Assert.assertNotEquals(CurrentURL, ExpectedURL,"ResultMsg");
    Assert.assertTrue(true);
   // Assert.assertFalse(false);
   // Assert.fail();:->directly mark fail
    * 
    * 
    * 
    * 
    * SOFT ASSERT:-
    *  if testcase contain multiple testmethod and any paricular testmethod fails at points.
    * it will memorised the result and executerest of teststeps.
    * after the execution of complete step asserAll() will call it result and
    * testcase will be marked as passed or failed accordingly.
    * for ther soft assertion we need 
      SoftAssert class ftom testng
    * it contain nonstatic method,create obj of SoftAssert class.
    * s.assertEquals(CurrentURL, ExpectedURL);
      
    //  s.assertAll("ResultMsg");
     // System.out.println(ResultMsg);
     /*s.assertNotEquals(CurrentURL, ExpectedURL);
    s.assertTrue(true);//return boolean val
    s.assertFalse(false);
    s.assertAll();*/
   
