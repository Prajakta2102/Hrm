package test_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Launch 
{
	static WebDriver driver;
	public static WebDriver Open_Browser(String browsernm,String URL)
	{
			
	if (browsernm.equalsIgnoreCase("edge")) 
	{ 
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	} 
	else if (browsernm.equalsIgnoreCase("chrome")) 
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driver\\chromedriver.exe");
		
           ChromeOptions p=new ChromeOptions();
	      p.addArguments("--remote-allow-origins=*");
	    driver=new ChromeDriver(p);
	}

	else if (browsernm.equalsIgnoreCase("firefox")) 
	{
		WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	}
 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	return driver;
	
	}



}


