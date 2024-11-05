package Kane.Selenium_java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options=new ChromeOptions();
		
		//EdgeOptions options=new EdgeOptions();
		options.setAcceptInsecureCerts(true);
		//options.addEncodedExtensions("");
		//options.setCapability("proxy", proxy);
		WebDriver driver = new ChromeDriver(options);
		//WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
