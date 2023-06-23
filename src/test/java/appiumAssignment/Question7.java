package appiumAssignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Question7 extends BaseTestQ7{

	@Test(enabled = false)
	public void hybridTest() throws Exception {

		//  Select the country from drop down
		driver.findElement(By.id("android:id/text1")).click();
		String actionToScroll = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));";
		driver.findElement(AppiumBy.androidUIAutomator(actionToScroll));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Canada']")).click();

		// Type in the name using mobile Keyboard
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jon");

		// Hide keyboard
		driver.hideKeyboard();

		// Select gender from one of the radio buttons
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();

		//  Click on Lets go button
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		//  Add to cart
		// First Element
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		//  Click on cart icon
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		// Click on terms and condition button
		// Longpress
		WebElement element = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		driver.executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));

		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		//  Click on Proceed to payment on website button

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		//  Switch to browser
		Thread.sleep(10000);
		Set<String> contexts = driver.getContextHandles();
		// webview
		for (String context : contexts) {
			System.out.println(context);
		}

		String chromeBrowserContext = "WEBVIEW_com.androidsample.generalstore";
		driver.context(chromeBrowserContext);
		// Continue writing selenium scripting for browser automation
		driver.findElement(By.name("q")).sendKeys("dummy");
		driver.context("NATIVE_APP");

	}
}
