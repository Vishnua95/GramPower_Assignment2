package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferencePage {

	public PreferencePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	private WebElement preferenceDependencies; 
	
	@AndroidFindBy(id="android:id/checkbox")
	private WebElement wifiCheckbox;
	
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	private WebElement wifiSettings;
	
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement wifiSettingsTextBox;
	
	@AndroidFindBy(className="android.widget.Button")
	private List<WebElement> wifiSettingsOkButton;
	
	public WebElement getPreferenceDependencies() {
		return preferenceDependencies;
	}
	
	public WebElement getWifiCheckbox() {
		return wifiCheckbox;
	}
	
	public WebElement getWifiSettings() {
		return wifiSettings;
	}
	
	public WebElement getWifiSettingsTextBox() {
		return wifiSettingsTextBox;
	}
	
	public List<WebElement> getWifiSettingsOkButton() {
		return wifiSettingsOkButton;
	}
	
}
