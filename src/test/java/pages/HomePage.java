package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GenericFunctions;

public class HomePage{

	WebDriver driver;
	GenericFunctions generic;
	
	public By filterButton = By.id("filterBtn");
	public By productGrid=By.id("product_grid");
	public By AppliAirXNightLabel= By.xpath("//h3[text()='Appli Air x Night']");


	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	public void filterShoesWithColour(String colour) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[contains(text(),'"+colour+"')]")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(filterButton))).click();
	}

	public void clickShoe(By xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath))).click(); 
	}
	
	public void clickAppliAirXNight() {
		clickShoe(this.AppliAirXNightLabel);
	}

}
