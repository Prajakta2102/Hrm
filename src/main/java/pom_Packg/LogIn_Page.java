package pom_Packg;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;//@FinBy annotation 
import org.openqa.selenium.support.PageFactory;//PageFactory class -->intiElements methods

import POM_UtilityPckg.ExplicitWait_WebEle;

public class LogIn_Page 
{
	
	WebDriver driver;//global 
	
	//static WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement Username;//encapsulation(strictly)(private var)

	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;//encapsulation

	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement LoginButton;//encapsulation

	
	//each POM will contain separate method for individual webele

	public LogIn_Page(WebDriver driver)//(local driver) intialize constr/para constructor with public
	{
		PageFactory.initElements(driver,this);//to protect from StaleEleRefException(performing actions on exsting webele on another webpage) 
		this.driver=driver;
		
		
		/*Local driver is assigned to global using this.driver=driver to ensure same driver is used throughout program.
If you do not use this keyword, local will be used.*/
}

	public void enter_Username(String uName)//utilize all data member with access specifier public.
	{
		//ExplicitWait_WebEle.Explicit_wait(driver, 10, "//input[@placeholder='Username']");
		
		Username.sendKeys(uName);//constructor reintialized  like this.username=uname;
	      
	}

	public void enter_Password(String pwd)
	{
		//ExplicitWait_WebEle.Explicit_wait(driver, 10,"//input[@name='password']" );
		
		Password.sendKeys(pwd);
	}
	public void clickOn_LogInBtn()
	{
		//ExplicitWait_WebEle.Explicit_wait(driver, 10, "//button[text()=' Login ']");
	  LoginButton.click();
		
	}
    public boolean toVerifyLogInButton()
    {
	   return LoginButton.isDisplayed();
	}
    public String toGetLogInButtonText()
    {
	   return LoginButton.getText();
	}
    public String toCheckActualURL()
    {
    	
    	String s=driver.getCurrentUrl();
    	 return s;
	}
    public String toVerifyTitleOfPage()
    {
    	return  driver.getTitle();
    	
    }
    public void clear_Username()//utilize all data member with access specifier public.
	{
		//ExplicitWait_WebEle.Explicit_wait(driver, 10, "//input[@placeholder='Username']");
		
		Username.sendKeys(Keys.CONTROL + "a"+Keys.BACK_SPACE);;//constructor reintialized  like this.username=uname;
	      
    	//Username.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	
	}

	public void clear_Password()
	{
		//ExplicitWait_WebEle.Explicit_wait(driver, 10,"//input[@name='password']" );
		
		Password.sendKeys(Keys.CONTROL + "a"+Keys.BACK_SPACE);
		//Password.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	}
  //POM classes will not contain main method
}



