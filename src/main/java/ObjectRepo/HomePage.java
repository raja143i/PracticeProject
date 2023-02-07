package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(linkText="Organizations")
    private WebElement Org;
    
    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement adminImg;
    
    @FindBy(xpath="//a[text()='Sign Out']")
    private WebElement signOut;

	public WebDriver driver;
    
    public HomePage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }

	public WebElement getOrg() {
		return Org;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}
    
}
