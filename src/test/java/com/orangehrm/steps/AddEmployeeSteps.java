package com.orangehrm.steps;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AddEmployeeSteps extends CommonMethods{
	
	public static LoginPage login;
	public static HomePage home;
	public static AddEmployeePage addEmp;
	

	@Given("I logged in into OrangeHrm")
	public void i_logged_in_into_OrangeHrm() {
		LoginPage login=new LoginPage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("I click on PIM")
	public void i_click_on_PIM() {
		click(home.PIM);
	}

	@When("I click on Add Employee link")
	public void i_click_on_Add_Employee_link() {
		click(home.addEmployee);
	}

	@When("I provide Employee details")
	public void i_provide_Employee_details(String fName, String mName, String lName) {
		
		addEmp=new AddEmployeePage();
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		click(addEmp.location);
	//	selectList(addEmp.locationList, location);
	}

	@When("I click on save button")
	public void i_click_on_save_button() {
	    click(addEmp.saveBtn);
		
	}

	@Then("I see Employee is added successfully")
	public void i_see_Employee_is_added_successfully(String fName, String lName) {
	    waitForElementBeClickable(addEmp.empCheck, 20);
	    String verifyText=addEmp.empCheck.getText();
	    System.out.println(verifyText);
	    Assert.assertEquals(verifyText,  fName+" "+lName);
	    
		
	}
	
}
