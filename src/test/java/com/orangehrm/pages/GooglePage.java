package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orangehrm.utils.BaseClass;

public class GooglePage extends BaseClass{
	
	@FindBy(css="input#fakebox-input")
	public WebElement search;

}
