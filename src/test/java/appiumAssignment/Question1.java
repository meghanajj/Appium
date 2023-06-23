package appiumAssignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Question1 {

	@Test
	public void firstTest() throws MalformedURLException {
		
		//default appium server
		String urlOfAppiumServer = "http://127.0.0.1:4723";
		//create instance of appiumserverURL
		URL appiumServalUrl = new URL(urlOfAppiumServer);
		UiAutomator2Options options = new UiAutomator2Options();
		//mention the device name to be used from android studio
		options.setDeviceName("Pixel");
		//location of the app to be launched
		options.setApp("C:\\Users\\Kiran\\eclipse-workspace\\appiumTraining\\training\\src\\test\\resources\\ApiDemos-debug.apk");
		//start the android driver 
		AndroidDriver driver = new AndroidDriver(appiumServalUrl, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
	}
}
