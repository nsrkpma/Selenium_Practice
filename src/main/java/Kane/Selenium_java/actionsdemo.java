package Kane.Selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsdemo {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//implicit wait of 5 seconds if element is found within 5 seconds it continues , 
		//if not found  waits for 5 seconds before giving error
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.amazon.in/");
		
		WebElement target=driver.findElement(By.id("nav-link-accountList"));
		WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
		Actions a= new Actions(driver);
		
		//move to element
		a.moveToElement(target).build().perform();
		
		//enter capital letters
		a.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("iphone").build().perform();
		// TODO Auto-generated method stub

	}

}
