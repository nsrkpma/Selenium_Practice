package Kane.Selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int columnCount=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size();
		int rowCount=(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size()-1);
		java.util.List<WebElement>secondRow=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[2]"));
		
		System.out.println("Rows Count= "+rowCount);
		System.out.println("Column Count= "+columnCount);
		System.out.println(secondRow.get(0).getText());
		System.out.println(secondRow.get(1).getText());
		System.out.println(secondRow.get(2).getText());
	}

}
