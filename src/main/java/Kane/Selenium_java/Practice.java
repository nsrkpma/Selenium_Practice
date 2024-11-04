package Kane.Selenium_java;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		
		driver.findElement(By.xpath("//input[@value='user']")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable((By.xpath("//button[@id='okayBtn']"))));
		
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.id("signInBtn")).click();
		Thread.sleep(5000);
		List<WebElement> Addbuttons=driver.findElements(By.xpath("//button[contains(text(), 'Add')]"));
		for(int i=0;i<Addbuttons.size();i++) {
			Addbuttons.get(i).click();
		}
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.xpath("//a[contains(text(),'India')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'I agree with the')]")).click();
		driver.findElement(By.xpath("//input[@value='Purchase']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
	}

}
