package test_Classes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG1 {

	@BeforeClass
	public void beforeClass1()
	{
		System.out.println("beforeClass1");
	}

	@BeforeMethod
	 public void beforeMethod1()
        {
			System.out.println("beforeMethod1");
		}
	@Test
	    public void test1()
		{
			System.out.println("test1");
		}
	 
	 @Test
	 public void test2()
	 {
		 System.out.println("test2"); 
	 }
	 @Test
	 public void test3()
	 {
		 System.out.println("test3"); 
	 }


	/* @AfterMethod
	 public void aftermethod1()
		{
			System.out.println("aftermethod1");
		}
	*/
	 @AfterClass
	 public void afterClass1()
		{
			System.out.println("afterClass1");
		}
}
