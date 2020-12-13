package Automation.AppiumPractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	public  AndroidDriver<AndroidElement> driver;
	public  AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startServer() {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		return service;
	}

	@SuppressWarnings("deprecation")
	public AndroidDriver<AndroidElement> setUpDriver() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		
		FileInputStream fis = new FileInputStream(projectPath + "/global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		File fs = new File(projectPath + prop.getProperty("appName"));
		System.out.println(projectPath);

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("device"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		driver = new AndroidDriver<AndroidElement>(new URL(prop.getProperty("url")), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

}
