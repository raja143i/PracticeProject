package com.vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrg {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		
	 WebDriver driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("http://localhost:8888");
	 driver.manage().window().maximize();
	 driver.findElement(By.name("user_name")).sendKeys("admin");
	 driver.findElement(By.name("user_password")).sendKeys("admin");
	 driver.findElement(By.id("submitButton")).click();
	 
	 driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	 
	 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	 driver.findElement(By.name("accountname")).sendKeys("sindhuja1");
	 WebElement IDD = driver.findElement(By.name("industry"));
	 Select s=new Select(IDD);
	 s.selectByValue("Banking");
	 WebElement ADD = driver.findElement(By.name("accounttype"));
	 Select s2=new Select(ADD);
	 s2.selectByValue("Analyst");
	 driver.findElement(By.name("button")).click();
	 
	 Thread.sleep(3000);
	 WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 Actions a=new Actions(driver);
	 a.moveToElement(adminImg).perform();
	 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
