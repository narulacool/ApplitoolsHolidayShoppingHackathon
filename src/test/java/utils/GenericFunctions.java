package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Config.Browsers;

public class GenericFunctions {

	WebDriver driver;

	public GenericFunctions(){

	}

	public GenericFunctions(WebDriver driver){
		this.driver=driver;
	}
	
	public WebDriver startDriver(Browsers browser) {
		if(browser.equals(Browsers.CHROME))
		{	
			System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("chromeDriver/chromedriver.exe").getPath());
			driver = new ChromeDriver();
		}
		else if(browser.equals(Browsers.FIREFOX))
		{	
			System.setProperty("webdriver.gecko.driver", getClass().getClassLoader().getResource("geckoDriver/geckodriver.exe").getPath());
			driver = new FirefoxDriver();
		}
		else if(browser.equals(Browsers.EDGECHROMIUM))
		{	
			System.setProperty("webdriver.edge.driver", getClass().getClassLoader().getResource("edgeDriver/msedgedriver.exe").getPath());
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Unsupported Browser!");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Dimension targetSize = new Dimension(1200,800);
		driver.manage().window().setSize(targetSize);

		return driver;
	}

	public void openUrl(String url) {
		driver.get(url);
	}

}
