package Kane.Selenium_java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class Selenium_introduction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		//implicit wait of 5 seconds if element is found within 5 seconds it continues , 
		//if not found  waits for 5 seconds before giving error
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//driver.wait(3000);
		
		LogIn(driver);
		//Thread.sleep(4000);
		//WebElement error=driver.findElement(By.cssSelector("p.error"));
		//System.out.println(error.getText());
		
		//WebElement forgotPassword= driver.findElement(By.linkText("Forgot your password?"));
		//forgotPassword.click();
		//Thread.sleep(5000);
		//WebElement visitUsButton=driver.findElement(By.xpath("//button[@id='visitUsTwo']"));
		//visitUsButton.click();
		Thread.sleep(3000);
		//driver.quit();
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		//Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");    
		LogOut(driver);
	}
	
	public static void LogIn(WebDriver driver) {
		
		String name="Queenrogue";
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		WebElement username= driver.findElement(By.id("inputUsername"));
		username.sendKeys("Kingkane");
		username.clear();
		username.sendKeys(name);
		WebElement password= driver.findElement(By.name("inputPassword"));
		password.sendKeys("rahulshettyacademy");
		WebElement signInButton= driver.findElement(By.className("signInBtn"));
		signInButton.click();
		
	}
	public static void LogOut(WebDriver driver) {
		WebElement LogOutButton= driver.findElement(By.className("logout-btn"));
		LogOutButton.click();
		
		driver.quit();
	}
	public static void closemethod(WebDriver driver) {
		driver.close();
	}

}
