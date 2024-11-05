package Kane.Selenium_java;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorspractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditbox=driver.findElement(By.name("name"));
	System.out.println( driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameEditbox)).getText());
	
	WebElement labelcheckbox=driver.findElement(By.xpath("//label[contains(text(),'Check me out if you Love IceCreams!')]"));
	driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(labelcheckbox)).click();
		
	//Get Height and width of element 
	System.out.println(nameEditbox.getRect().getDimension().getHeight());
			
	System.out.println(nameEditbox.getRect().getDimension().getWidth()); 
	
	//take Screenshot
	
	File file= nameEditbox.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File("D:\\Selenium Java\\Selenium_java\\boxbefore.png"));
	
	nameEditbox.sendKeys("KINGKANE");
	File file1= nameEditbox.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file1, new File("D:\\Selenium Java\\Selenium_java\\boxafter.png"));
	
	}

}
