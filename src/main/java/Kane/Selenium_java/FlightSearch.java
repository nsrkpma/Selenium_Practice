package Kane.Selenium_java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FlightSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		//implicit wait of 5 seconds if element is found within 5 seconds it continues , 
		//if not found  waits for 5 seconds before giving error
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.id("originInput-input")).sendKeys(Keys.CLEAR);
		driver.findElement(By.id("originInput-input")).sendKeys("Pune");
		driver.findElement(By.id("originInput-input")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		driver.close();
	}

}
