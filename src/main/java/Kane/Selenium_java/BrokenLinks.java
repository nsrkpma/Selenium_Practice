package Kane.Selenium_java;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub

		//java methods to
		//ChromeOptions options=new ChromeOptions();
		
		//EdgeOptions options=new EdgeOptions();
		//options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement>links=driver.findElements(By.cssSelector("li[class='gf-li']"));
		
		for(int i=0;i<links.size();i++) {
		String url = links.get(i).getAttribute("href");
		HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int responsecode=conn.getResponseCode();
		System.out.println(responsecode);
		//conn.disconnect();
	}}
	
}