package Kane.Selenium_java;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Waits {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//implicit wait of 5 seconds if element is found within 5 seconds it continues , 
		//if not found  waits for 5 seconds before giving error
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] itemsneeded= {"Cucumber","Brocolli","Beetroot"};
		
		additems(driver,itemsneeded);
		driver.findElement(By.className("cart-icon")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//Explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated((By.className("promoCode"))));

		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[@class='promoInfo']"))));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText(),"Code applied ..!");
		

	}

	public static void additems(WebDriver driver,String[]itemsneeded) {
		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++)
		{
			String[] name=products.get(i).getText().split("-");
			String formattedName=name[0].trim();
			List itemsneededlist=Arrays.asList(itemsneeded);
			
			if(itemsneededlist.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsneeded.length) {
					break;
				}
			}
		}
	}
}
