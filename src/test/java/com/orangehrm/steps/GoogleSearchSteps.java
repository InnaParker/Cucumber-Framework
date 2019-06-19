package com.orangehrm.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {

	
	@Given("I navigated to the Google page")
	public void i_navigated_to_the_Google_page() {
	    System.out.println("I am on Google page");
	}

	@When("I type search item")
	public void i_type_search_item() {
	   System.out.println("I search for item");
	}

	@When("I click on search google search button")
	public void i_click_on_search_google_search_button() {
	    System.out.println("Click search button");
	}

	@Then("I see search results are displayed")
	public void i_see_search_results_are_displayed() {
	    System.out.println("Results are displayed");
	}
}
