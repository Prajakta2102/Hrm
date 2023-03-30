package POM_UtilityPckg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;

public class ExplicitWait_WebEle 
{
   public static void Explicit_wait(WebDriver driver,int time ,String webele_ref)
   {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webele_ref)));
   }



}
