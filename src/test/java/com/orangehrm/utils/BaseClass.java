package com.orangehrm.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public static WebDriver driver;


	public static void setUp() 
	{
		ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
		String browser = ConfigsReader.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "src/test/recources/drivers/geckodriver");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", "src/test/recources/drivers/IEDriverServer");
			driver = new InternetExplorerDriver();

		} else {

			System.out.println("Please use valid browser");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(ConfigsReader.getProperty("url"));
	}

	public static void tearDown() 
	{
		driver.quit();
	}
	
}
