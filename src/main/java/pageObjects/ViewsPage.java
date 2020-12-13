package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ViewsPage {

	public ViewsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(text('WebView'));")
	private WebElement webViewTab; 
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='TextClock']")
	private WebElement textClockTab;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Expandable Lists']")
	private WebElement expandListTab;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='1. Custom Adapter']")
	private WebElement customAdapterOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=['People Names']")
	private WebElement peopleNames;
	
	@AndroidFindBy(id="android:id/alertTitle")
	private WebElement sampleMenu;
	
	public WebElement getWebViewTab() {
		return webViewTab;
	}
	
	public WebElement getTextClockTab() {
		return textClockTab;
	}
	
	public WebElement getExpandListTab() {
		return expandListTab;
	}
	
	public WebElement getCustomAdapterOption() {
		return customAdapterOption;
	}
	
	public WebElement getPeopleNames() {
		return peopleNames;
	}
	
	public WebElement getSampleMenu() {
		return sampleMenu;
	}
	
}
