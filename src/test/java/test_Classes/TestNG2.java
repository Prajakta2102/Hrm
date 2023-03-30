package test_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class TestNG2 {
	WebDriver driver;

	

	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("beforesuit");
	}

	@Parameters({ "browsernm" })
	@BeforeTest
	public void BeforeTest(String browsernm) {
	}

	@BeforeClass
	public void beforeClass2() {
		System.out.println("beforeClass2");
	}

	@BeforeMethod
	public void beforeMethod2() {
		System.out.println("beforeMethod2");
	}

	@Test
	public void test4() {
		System.out.println("test4");
	}

	@Test
	public void test5() {
		System.out.println("test5");
	}

	@Test
	public void test6() {
		System.out.println("test6");
	}

/*	@AfterMethod
	public void aftermethod2() {
		System.out.println("aftermethod2");
	}*/

	@AfterClass
	public void afterClass2() {
		System.out.println("afterClass2");
	}

	@AfterTest
	public void afterTest() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		// System.out.println("aftertest");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("aftersuit");
	}

}
