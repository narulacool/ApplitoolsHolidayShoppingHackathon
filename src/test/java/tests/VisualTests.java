package tests;

import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;

import pages.HomePage;
import utils.EyesConfig;
import utils.GenericFunctions;
import utils.UrlProvider;
import utils.Config.Browsers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisualTests {
	EyesConfig eyeConfig; 
	VisualGridRunner runner;
	Eyes eyes;
	WebDriver driver;
	GenericFunctions generic;
	UrlProvider urlProvider;
	Browsers browser;
	
	@BeforeClass
	public void setBatch() {
		eyeConfig = new EyesConfig("Holiday Shopping");
		// Create a runner with concurrency of 10
		runner = new VisualGridRunner(10);
		
		// Create Eyes object with the runner, meaning it'll be a Visual Grid eyes.
		eyes = new Eyes(runner);

		//Setup eyes
		eyeConfig.setUp(eyes);
	}

	@BeforeMethod
	public void initialize() {	

		//Initialize variables & launch browser
		generic = new GenericFunctions();
		urlProvider = new UrlProvider();
		browser = Browsers.CHROME;
		driver = generic.startDriver(browser);
		generic = new GenericFunctions(driver);
	}

	
	/**
	 * Test 1 - Check Main Page 
	 */
	@Test
	public void checkMainPage() {
		try {

			// Navigate to the url we want to test
			generic.openUrl(urlProvider.getFinalProductionUrl());

			// Call Open on eyes to initialize a test session
			eyes.open(driver, eyeConfig.appName, "Test 1");

			// check the main page
			eyes.check(Target.window().fully().withName("main page"));

			// Call Close on eyes to let the server know it should display the results
			eyes.closeAsync();

		} finally  {
			eyes.abortAsync();
		}
	}

	
	/**
	 * Test2 - Check Filtered Product Grid
	 */
	@Test
	public void checkFilteredProductGrid() {
		try {

			// Navigate to the url we want to test
			generic.openUrl(urlProvider.getFinalProductionUrl());

			//Filter shoes with Black colour
			HomePage homePage = new HomePage(driver);
			homePage.filterShoesWithColour("Black");

			// Call Open on eyes to initialize a test session
			eyes.open(driver, eyeConfig.appName, "Test 2");

			// check the productgrid region
			eyes.check(Target.region(homePage.productGrid).withName("filter by color"));

			// Call Close on eyes to let the server know it should display the results
			eyes.closeAsync();

		} finally  {
			eyes.abortAsync();
		}
	}

	
	/**
	 * Test 3 – check Product Details
	 */
	@Test
	public void task3_ProductDetailsTest() {
		try {

			// Navigate to the url we want to test
			generic.openUrl(urlProvider.getFinalProductionUrl());

			//Filter shoes with Black colour and open first shoe
			HomePage homePage = new HomePage(driver);
			homePage.clickAppliAirXNight();

			// Call Open on eyes to initialize a test session
			eyes.open(driver, eyeConfig.appName, "Test 3");

			// check the product Details page
			eyes.check(Target.window().fully().withName("product details"));

			// Call Close on eyes to let the server know it should display the results
			eyes.closeAsync();

		} finally  {
			eyes.abortAsync();
		}
	}

	@AfterMethod
	private void tearDown() {
		// Close the browser
		driver.quit();

		/*// we pass false to this method to suppress the exception that is thrown if we find visual differences
		TestResultsSummary allTestResults = runner.getAllTestResults(false);
		System.out.println(allTestResults);*/
	}
	
	@AfterClass
	private void tearDownClass() {

		// we pass false to this method to suppress the exception that is thrown if we find visual differences
		TestResultsSummary allTestResults = runner.getAllTestResults(false);
		System.out.println(allTestResults);
	}
	
}
