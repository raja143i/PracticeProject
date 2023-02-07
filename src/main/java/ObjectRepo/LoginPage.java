package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
@FindBy(name="user_name")
private WebElement uName;

@FindBy(name="user_password")
private WebElement pWord;

@FindBy(id="submitButton")
private WebElement submitbtn;

public WebDriver driver;

public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebElement getuName() {
	return uName;
}

public WebElement getpWord() {
	return pWord;
}

public WebElement getSubmitbtn() {
	return submitbtn;
}


}
