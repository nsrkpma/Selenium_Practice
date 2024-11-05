package Kane.Selenium_java;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test1 {

	@BeforeTest
	public void clockin() {
		System.out.println("I am doing cockin");
	}

	@BeforeMethod
	public void Login() {

		System.out.println("I am doing Login");
	}

	@Test
	public void Logout() {

		System.out.println("I am doing Logout");
	}

	@Test
	public void ViewChecks() {

		System.out.println("I am viewing checks");
	}

	@Test
	public void ViewReports() {

		System.out.println("I am viewing reports");
	}
	
	@Test
	public void Payment() {
		
		System.out.println("I am doing Payment");
	}
	@Test
	public void Applycoupon() {
		
		System.out.println("I am applying coupon");
	}
}
