package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgClass {
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CorgBtn;
	
	@FindBy(name="accountname")
	private WebElement orgNameTf;
	
	@FindBy(name="industry")
	private WebElement indDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(name="button")
	private WebElement sBtn;

	public WebDriver driver;
	
	public CreateOrgClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getCorgBtn() {
		return CorgBtn;
	}

	public WebElement getOrgNameTf() {
		return orgNameTf;
	}

	public WebElement getIndDD() {
		return indDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getsBtn() {
		return sBtn;
	}
	

}
