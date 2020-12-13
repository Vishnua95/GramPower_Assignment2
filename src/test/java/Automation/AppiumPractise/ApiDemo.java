package Automation.AppiumPractise;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.HomePage;
import pageObjects.PreferencePage;
import pageObjects.ViewsPage;

public class ApiDemo extends Base{
	
	//HomePage objects creation
	HomePage home = new HomePage(driver);
	//PreferencePage objects creation
	PreferencePage preference = new PreferencePage(driver);
	//ViewsPage objects creation
	ViewsPage views = new ViewsPage(driver);
	//Utilities Scrolling
	Utilities util = new Utilities(driver);
	
	@BeforeMethod
	public void setUp() throws IOException {
		service = startServer();
		setUpDriver();
	}
	
	@Test(priority = 1)
	public void setPreferences() throws MalformedURLException {
		
		//Click on Preference button
		home.getPreference().click();
		//Click on Preference Dependencies button
		preference.getPreferenceDependencies().click();
		//Click WiFi Checkbox
		preference.getWifiCheckbox().click();
		//Click on WiFi settings button
		preference.getWifiSettings().click();
		//Entering "Hello" in the text box popup
		preference.getWifiSettingsTextBox().sendKeys("Hello");
		//Click on OK button
		preference.getWifiSettingsOkButton().get(1).click();
		//Navigating backwards twice
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));	
	}
	
	@Test(priority = 2)
	public void chooseView() throws MalformedURLException {
		
		//Click on Views button
		home.getViews().click();
		//Scroll till last tab "WebView"
		util.scrollToText("WebView");
		//Click on TextClock button
		views.getTextClockTab().click();
		//Navigating backward once
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		//Scroll to the top "Animation"
		util.scrollToText("Animation");
		//Creating action object
		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction(driver);
		//Click on Expandable Lists button
		views.getExpandListTab().click();
		//Click on Custom Adapter Option
		views.getCustomAdapterOption().click();
		//Long Press on "People Names" tab
		action.longPress(longPressOptions().withElement(element(views.getPeopleNames())).withDuration(ofSeconds(3))).release().perform();
		//Asserting whether the menu is displayed on screen
		Assert.assertTrue(views.getSampleMenu().isDisplayed());
		
	}
	
	@AfterMethod
	public void tearDown() {
		service.stop();
	}

}
