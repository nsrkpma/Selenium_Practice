package Kane.Selenium_java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutocompleteDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("United");
		Thread.sleep(1000);
		List<WebElement> suggestions=driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
		String country="United Arab Emirates";
		for(int i=0;i<suggestions.size();i++) {
			System.out.println(suggestions.get(i).getText());
			if((suggestions.get(i).getText()).equalsIgnoreCase(country)) {
				suggestions.get(i).click();
				break;
			}
		}

	}

}
