package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class AddEmployeePage extends BaseClass{
	
	@FindBy(id="firstName")
    public WebElement firstName;
    
    @FindBy(id="middleName")
    public WebElement middleName;
    
    @FindBy(id="lastName")
    public WebElement lastName;
    
    @FindBy(id="employeeId")
    public WebElement employeeId;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//input")
    public WebElement location;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
    public WebElement locationList;
    
    @FindBy(xpath="//input[@id='chkLogin']")
    public WebElement createLoginDetails;
    
    @FindBy(id="systemUserSaveBtn")
    public WebElement saveBtn;
    
    @FindBy(xpath="//span[@id='pim.navbar.employeeName']")
    public WebElement empCheck;
    
    @FindBy(xpath="//form[@id='pimAddEmployeeForm']//label")
    public List <WebElement> addEmpLabels;
    
    @FindBy(id="username")
    public WebElement username;
    
    @FindBy(id="password")
    public WebElement password;
    
    @FindBy(id="confirmPassword")
    public WebElement confirmPassword;
    
    @FindBy(xpath="//div[@id='essRoleId_inputfileddiv']//input")
    public WebElement essRole;
    
    @FindBy(xpath="//div[@id='essRoleId_inputfileddiv']//ul")
    public WebElement essRoleList;
    
    @FindBy(xpath="//div[@id='supervisorRoleId_inputfileddiv']//input")
    public WebElement supervisorRole;
    
    @FindBy(xpath="//div[@id='supervisorRoleId_inputfileddiv']//ul")
    public WebElement supervisorRoleList;
    
    
    public AddEmployeePage() {
        PageFactory.initElements(driver,this);
    }

}
