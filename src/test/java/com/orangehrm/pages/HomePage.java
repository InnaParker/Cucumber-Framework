package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy (css="li[class='page-title']")
	public WebElement dashboardText;
	
	@FindBy(partialLinkText="PIM")
    public WebElement PIM;
	
    @FindBy(partialLinkText="Add Employee")
    public WebElement addEmployee;
    
    @FindBy (css="div[class='toast-message']")
	public WebElement errorText;

	
	public HomePage(){
		PageFactory.initElements(driver, this);

	}
	
	
}
