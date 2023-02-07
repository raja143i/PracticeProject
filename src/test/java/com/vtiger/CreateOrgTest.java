package com.vtiger;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import ObjectRepo.CreateOrgClass;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import Utilitiess.ExileFile;
import Utilitiess.PropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgTest {
@Test
 public void createorg() throws Throwable {
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	PropertyFile p=new PropertyFile();
	LoginPage l=new LoginPage(driver);
	driver.get(p.readDataFromProperty("url"));
	l.getuName().sendKeys(p.readDataFromProperty("username"));
	l.getpWord().sendKeys(p.readDataFromProperty("password"));
	l.getSubmitbtn().click();
	
	HomePage h=new HomePage(driver);
	h.getOrg().click();
	
	
	CreateOrgClass coc=new CreateOrgClass(driver);
	coc.getCorgBtn().click();
	Random r=new Random();
	int num = r.nextInt(100);
	ExileFile e=new ExileFile();
	coc.getOrgNameTf().sendKeys(e.Excel("sheet1", 2, 0)+num);
	WebElement indd = coc.getIndDD();
	Select s=new Select(indd);
	s.selectByValue("Banking");
	
	WebElement tdd = coc.getTypeDD();
	Select  s1=new Select(tdd);
	s1.selectByValue("Analyst");
	
	coc.getsBtn().click();
	Thread.sleep(3000);
	
	WebElement admn = h.getAdminImg();
	
	Actions a=new Actions(driver);
	a.moveToElement(admn).perform();
	h.getSignOut().click();
	
}
	
}
