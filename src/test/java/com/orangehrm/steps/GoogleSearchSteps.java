package com.orangehrm.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps extends CommonMethods {

	String url="http://www.google.com";
		
	@Given("I navigated to the Google page")
	public void i_navigated_to_the_Google_page() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/inna/eclipse-workspace/CucumberFramework/src/test/resources/drivers/chromedriver");
		driver=new ChromeDriver();
		driver.get(url);
	    
	}

	@When("I type search item")
	public void i_type_search_item() {
		
		WebElement search=driver.findElement(By.cssSelector("input#fakebox-input"));
		CommonMethods.sendText(search, "iPhone");
	}

	@When("I click on search google search button")
	public void i_click_on_search_google_search_button() {
		WebElement searchBtn=driver.findElement(By.xpath("//div[@class='VlcLAe']//center//input[1]"));
		CommonMethods.click(searchBtn);
		
	}

	@Then("I see search results are displayed")
	public void i_see_search_results_are_displayed() {
	    
		boolean isDisplayedResult=driver.findElement(By.xpath("//div[@id='resultStats']")).isDisplayed();
		System.out.println("Search results are displayed");
	}
	
}
