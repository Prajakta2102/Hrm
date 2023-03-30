package pom_Packg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Admin_Page 
{
	static WebDriver driver;
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement Admin;
	
	@FindBy(xpath="//span[text()='User Management ']")
	private WebElement UserMnagement;
	

	public Home_Admin_Page(WebDriver driver)//contstructor
    {
    	PageFactory.initElements(driver,this);
    	this.driver=driver;
    }
	
    public void click_Admin()//public nonstatic
	{
		Admin.click();
	}
    public String getText_Admin()
    {
    	String text=Admin.getText();
    	System.out.println(text);
    	return text;
    }
    
    public void click_UserManagement()
   	{
    	UserMnagement.click();
   	}
    
	
	
}
