package com.sample.test.practice;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerTest {
	@Test
public void loginLogoutVtiger() {
		WebDriver driver=null;
		String url=System.getProperty("url");
		System.out.println(url);
		String browser=System.getProperty("browser");
		System.out.println(browser);
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Provide browser name");
//		String browser=sc.nextLine();
		String username=System.getProperty("username");
		System.out.println(username);
//		System.out.println("provide username");
//		String username=sc.nextLine();
		String password=System.getProperty("password");
		System.out.println(password);
//		System.out.println("provide password");
//		String password=sc.nextLine();
		WebDriverManager.chromedriver().setup();
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password, Keys.ENTER);
	
	WebElement administrator=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act= new Actions(driver);
	act.moveToElement(administrator).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	driver.close();
}
}
