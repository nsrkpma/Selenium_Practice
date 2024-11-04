package Kane.Selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class iframespractive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		driver.findElement(By.id("draggable")).click();
		Actions a= new Actions(driver);
		WebElement sourcedrag=driver.findElement(By.id("draggable"));
		WebElement targetdrop=driver.findElement(By.id("droppable"));
		a.dragAndDrop(sourcedrag, targetdrop).build().perform();
	}

}
