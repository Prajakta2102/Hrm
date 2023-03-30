package test_Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Screenshot_Proof 
{
	
	/*public static void screen_shot(WebDriver driver,String date)throws IOException
	{
		Date d=new Date();
		date=d.toString().replace(":","_").replace(":","_");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\eclipse\\HRMOrange\\src\\test\\resources\\TestclassScreenshot\\Screen."+date+".png");
	    FileHandler.copy(src, dest);
	}*/
	public static String screen_shot(WebDriver driver)throws IOException//for half page screenshot
	{
	/*	Date d=new Date();
		date=d.toString().replace(":","_").replace(":","_");*/
	    // String path="test-output"+File.separator+"Screenshot_Failure"+File.separator+date+".png";
		System.getProperty("user.dir");
		String path=System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"Screenshot_Failure"+File.separator+System.currentTimeMillis()+".png";
		//String path="C:\\eclipse\\HRMOrange\\test-output"+File.separator+"Screenshot_Failure"+File.separator+System.currentTimeMillis()+".png";
	//	String path="C:\\eclipse\\HRMOrange\\test-output\\Screenshot_Failure";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
	   FileHandler.copy(src, dest);
		return path;
	
	}
	//screenshot for specific webele
	/*public static void screen_shot(WebDriver driver)throws IOException
	{
		WebElement a1=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		File src=a1.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"Screenshot_Failure"+File.separator+System.currentTimeMillis()+".png");
		FileHandler.copy(src, dest);
	}*/
	

}
