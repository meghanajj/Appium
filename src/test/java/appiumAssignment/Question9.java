package appiumAssignment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Question9 extends BaseClassTest {
	

	@Test(enabled = false)
	public void scrollDemo() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//to scroll till a particular element
		String actionToScroll = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));";
		driver.findElement(AppiumBy.androidUIAutomator(actionToScroll));
		
		// Scroll down till end of screen
		boolean canScrollMore;

		do {

			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("direction", "down", "left", 100, "top", 100, "width", 200, "height", 200, "percent", 3.0));

		} while (canScrollMore);
		
		//close app after every test
		DesiredCapabilities driver= new DesiredCapabilities(); 
		driver.setCapability("shouldTerminateApp",true);
		
	}
	
	
	
	  

}
