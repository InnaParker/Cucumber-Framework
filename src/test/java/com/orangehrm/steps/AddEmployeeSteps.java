package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {

	public static LoginPage login;
	public static HomePage home;
	public static AddEmployeePage addEmp;

	//Background
	@Given("I logged in into OrangeHrm")
	public void i_logged_in_into_OrangeHrm() {

		login = new LoginPage();
		home = new HomePage();
		addEmp = new AddEmployeePage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@And("I click on PIM")
	public void i_click_on_PIM() {
		click(home.PIM);
	}

	@And("I click on Add Employee link")
	public void i_click_on_Add_Employee_link() {
		click(home.addEmployee);
	}

	//Scenario - Add Employee
	@When("I provide {string}, {string}, {string} and {string}")
	public void i_provide_and(String fName, String mName, String lName,
			String location) {

		addEmp = new AddEmployeePage();
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		click(addEmp.location);
		selectList(addEmp.locationList, location);
		// selectList(addEmp.locationList, location); //(emp.locationList, "HQ")
		// sendText(emp.firstName, "Jane");
	}

	@And("I click on save button")
	public void i_click_on_save_button() {
		click(addEmp.saveBtn);
	}

	@Then("I see {string}, {string} is displayed")
	public void i_see_is_displayed(String fName, String lName) {

		waitForElementBeClickable(addEmp.empCheck, 30);
		String empName = addEmp.empCheck.getText();
		Assert.assertEquals(empName, fName + " " + lName);
	}

	//Scenario - Add Employee Labels Verification
	@Then("I see following labels")
	public void i_see_following_labels(DataTable addEmpLabels) {
		
		//DataTable without a header
		List <String> expectedLabels = addEmpLabels.asList();
		System.out.println("--------Printing expected labels from cucumber dataTable-------");
		for (String label : expectedLabels) {
			System.out.println(expectedLabels);
		}
		
		//create empty array list where we store labels text
		List<String> actualLabels=new ArrayList<String>();
		
		//get all label elements
		List <WebElement> labelList=addEmp.addEmpLabels;
		for (WebElement label: labelList) {
			String labeltxt=label.getText();
			
			//if text is not empty replace * and store it inside actualLabels
			if (!labeltxt.isEmpty()) {
				actualLabels.add(labeltxt.replace("*", ""));
			}
		}
		Assert.assertTrue(actualLabels.equals(expectedLabels));
		//actualLabels.retainAll(actualLabels);
		}
	
	//Scenario - Add Employee and Create Login Details
	@When("I provide <{string}>, <{string}>, <{string}>, <{string}>")
	public void i_provide(String firstName, String middleName, String lastName, String location) {
	    addEmp=new AddEmployeePage();
	    sendText(addEmp.firstName, firstName);
	    sendText(addEmp.middleName, middleName);
	    sendText(addEmp.lastName, lastName);
	    click(addEmp.location);
	    selectList(addEmp.locationList, location);
	    
	}

	@When("I click on create login details")
	public void i_click_on_create_login_details() {
		click(addEmp.createLoginDetails);
	    
	}

	@When("I provide fields {string}, {string}, {string}, {string} and {string}")
	public void i_provide_fields_and(String userName, String password, String confirmPassword, String essRole, String supervisorRole) throws InterruptedException {
		Thread.sleep(2000);
		sendText(addEmp.username, userName);
	    sendText(addEmp.password, password);
	    sendText(addEmp.confirmPassword, confirmPassword);
	    click(addEmp.essRole);
	    Thread.sleep(2000);
	    selectList(addEmp.essRoleList, essRole);
	    click(addEmp.supervisorRole);
	    Thread.sleep(2000);
	    selectList(addEmp.supervisorRoleList, supervisorRole);
	    
	}

	@Then("I see employee is added successfully {string} and {string}")
	public void i_see_employee_is_added_successfully_and(String firstName, String lastName) {
	    String empName=addEmp.empCheck.getText();
	    Assert.assertEquals(firstName+" "+lastName, empName);
	}

}
