package Utilitiess;

import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	PropertyFile propertyFile;
	public HomePage h;
	@BeforeSuite(groups={"smoke","integtation"})
	public void connecttodb() {
		System.out.println("==> connect to dataBase ==>");
	}
	@AfterSuite(groups={"smoke","integration"})
	public void disconnecttodb() {
		System.out.println("==> disconnect to dataBase ==>");
	}
	
	@org.testng.annotations.BeforeClass(groups={"smoke","integration"})
	public void launchthebrowser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		sdriver=driver;
		propertyFile=new PropertyFile();
		driver.get(propertyFile.readDataFromProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass(groups={"smoke","integration"})
	public void closeTheBrowser() {
		driver.close();
	}
	@BeforeMethod(groups={"smoke","integration"})
	public void LoginToApp() throws Throwable {
	   propertyFile=new PropertyFile();
	   LoginPage l=new LoginPage(driver);
	   l.getuName().sendKeys(propertyFile.readDataFromProperty("username"));
	   l.getpWord().sendKeys(propertyFile.readDataFromProperty("password"));
	   l.getSubmitbtn().click();
	}
	@AfterMethod(groups={"smoke","integration"})
	public void logoutFromApp() {
		h=new HomePage(driver);
		WebElement admImg = h.getAdminImg();
		Actions a=new Actions(driver);
		a.moveToElement(admImg).perform();
		h.getSignOut().click();
	}
}
