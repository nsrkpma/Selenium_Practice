package Kane.Selenium_java;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scope {

	@Test
	public void LinkCounter() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		Assert.assertEquals(driver.findElements(By.tagName("a")).size(), 27);
		driver.close();

	}

	@Test
	public void FooterLinkCount() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// limiting webdriver scope
		WebElement footer = driver.findElement(By.cssSelector(".footer_top_agile_w3ls.gffoot.footer_style"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		Assert.assertEquals(footer.findElements(By.tagName("a")).size(), 20);
		driver.close();
	}

	@Test
	public void oneColumnLinkCount() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// limiting webdriver scope
		WebElement footer = driver.findElement(By.cssSelector(".footer_top_agile_w3ls.gffoot.footer_style"));
		WebElement leftcolumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> Links = leftcolumn.findElements(By.tagName("a"));
		for (int i = 0; i < Links.size(); i++) {
			System.out.println(Links.get(i).getText());
		}
		driver.close();
	}

	@Test
	public void ClickOnLinks() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// limiting webdriver scope
		WebElement footer = driver.findElement(By.cssSelector(".footer_top_agile_w3ls.gffoot.footer_style"));
		WebElement leftcolumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> Links = leftcolumn.findElements(By.tagName("a"));

		String clickonlinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (int i = 0; i < Links.size(); i++) {
			Links.get(i).sendKeys(clickonlinktab);
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			String parentid = it.next();
			String childid = it.next();
			driver.switchTo().window(childid);
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
			driver.close();
			driver.switchTo().window(parentid);
		}
		driver.close();
	}
}
