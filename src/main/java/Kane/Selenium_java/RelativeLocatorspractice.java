package Kane.Selenium_java;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorspractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditbox=driver.findElement(By.name("name"));
	System.out.println( driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameEditbox)).getText());
	
	WebElement labelcheckbox=driver.findElement(By.xpath("//label[contains(text(),'Check me out if you Love IceCreams!')]"));
	driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(labelcheckbox)).click();
		
	}

}
