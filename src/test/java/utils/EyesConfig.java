package utils;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;

public class EyesConfig {

	private String apiKey = "yXNFl7DYawHa109auVYlWKaUG8QmQ5a08n7VkYxrOnzGI110";

	public String appName = "AppliFashion";

	private String batchName;

	public EyesConfig(String batchName) {
		this.batchName = batchName;
	}

	public void setUp(Eyes eyes) {

		// Initialize eyes Configuration
		Configuration config = new Configuration();

		// You can get your api key from the Applitools dashboard
		config.setApiKey(apiKey);

		// create a new batch info instance and set it to the configuration
		config.setBatch(new BatchInfo(batchName));

		// Add browsers with different viewports
		config.addBrowser(1200, 800, BrowserType.CHROME);
		config.addBrowser(1200, 800, BrowserType.FIREFOX);
		config.addBrowser(1200, 800, BrowserType.EDGE_CHROMIUM);
		config.addBrowser(1200, 800, BrowserType.SAFARI);

		// Add mobile emulation devices in Portrait mode
		config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);

		// Set the configuration object to eyes
		eyes.setConfiguration(config);

	}

}
