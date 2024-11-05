package Kane.Selenium_java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scroll {

	@Test
	public void scrollDemo() {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int Sum=0;
		for(int i=0;i<values.size();i++) {
		System.out.println(Integer.parseInt(values.get(i).getText()));
		Sum+=Integer.parseInt(values.get(i).getText());
		}
		System.out.println(Sum);
		int printedValue=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		System.out.println(printedValue);
		Assert.assertEquals(Sum, printedValue);
		Selenium_introduction.closemethod(driver); 
		

	}

}
