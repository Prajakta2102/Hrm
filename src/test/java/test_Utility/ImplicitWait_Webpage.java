package test_Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class ImplicitWait_Webpage 
{
  public static void implicit_Wait(WebDriver driver,int time)
  {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
  }
}
