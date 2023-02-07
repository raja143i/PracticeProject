package com.group;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import ObjectRepo.CreateOrgClass;
import ObjectRepo.HomePage;
import Utilitiess.BaseClass;
import Utilitiess.ExileFile;

public class Group1 extends BaseClass {
	@Test(groups="smoke")
	public void createorg() throws Throwable {
   HomePage h=new HomePage(driver);
   h.getOrg().click();
   CreateOrgClass coc=new CreateOrgClass(driver);
   ExileFile e=new ExileFile();
   coc.getCorgBtn().click();
   Random r=new Random();
	int num = r.nextInt(100);
	coc.getOrgNameTf().sendKeys(e.Excel("sheet1", 2, 0)+num);
	WebElement indd = coc.getIndDD();
	Select s=new Select(indd);
	s.selectByValue("Banking");
	
	WebElement tdd = coc.getTypeDD();
	Select  s1=new Select(tdd);
	s1.selectByValue("Analyst");
	
	coc.getsBtn().click();
	Thread.sleep(3000);
}
}