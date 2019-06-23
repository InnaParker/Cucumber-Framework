package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orangehrm.utils.BaseClass;

public class AddLocationPage extends BaseClass{

	@FindBy(id="admin")
    public WebElement admin;
    
    @FindBy(id="organization")
    public WebElement organization;
    
    @FindBy(id="location")
    public WebElement location;
    
    @FindBy(id="add")
    public WebElement add;
    
    @FindBy(css="iput@name")
    public WebElement locationName;
    
    @FindBy(xpath="//*[@id='countryCode_inputfilediv']//div//input")
    public WebElement selectCountry;
    
    @FindBy(xpath="//*[@id='countryCode_inputfilediv']//div//ul/li")
    public List<WebElement> listOfCountries;
    
    @FindBy(css="input#city")
    public WebElement locationCity;
    
    @FindBy(css="input#zipCode")
    public WebElement locationZipCode;
    
    @FindBy(xpath="//a[text()='Save']")
    public WebElement saveBtn;
    
    @FindBy(css="//*/tbody/tr/td[2]")
    public List<WebElement> addedLocationsList;
	
}
