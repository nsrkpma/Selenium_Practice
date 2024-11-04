package Kane.Selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys("KING");

		driver.findElement(By.cssSelector("[id='alertbtn']")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();

		System.out.println(driver.switchTo().alert().getText());



		driver.switchTo().alert().dismiss();

	}

}
