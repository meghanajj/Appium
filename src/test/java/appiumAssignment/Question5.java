package appiumAssignment;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Question5 extends BaseClassTest {
	
	@Test(enabled = false)
	public void screenshot() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// Capture screenshot. 
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
	}
}
