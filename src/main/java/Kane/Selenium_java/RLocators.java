package Kane.Selenium_java;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.locators.RelativeLocator;


public class RLocators {


public static void main(String args[]) throws InterruptedException {

WebDriver driver;

driver = new ChromeDriver();

driver.get("https://rahulshettyacademy.com/angularpractice/");



WebElement nameEditbox=driver.findElement(By.name("name"));
  System.out.println( driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameEditbox)).getText());
  


}

}