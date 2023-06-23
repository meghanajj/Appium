package appiumAssignment;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseClassTest {
	AndroidDriver driver;
	AppiumDriverLocalService service;

	@BeforeClass
	public void setup() throws MalformedURLException, InterruptedException {
		System.out.println("Starting Appium Server Now...");

		// Appium JS File Location
		File appiumJS = new File("C:\\Users\\Kiran\\.android\\node_modules\\appium\\build\\lib\\main.js");

		String ipAddress = "127.0.0.1";
		int port = 4723;
		service = new AppiumServiceBuilder().usingPort(port).withIPAddress(ipAddress).withAppiumJS(appiumJS)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE).withLogFile(new File(System.getProperty("user.dir")
						+ "/target/resources/appium_server_logs" + Thread.currentThread().getId()))
				.build();
		service.start();
		Thread.sleep(20000);
		System.out.println("Appium Server Started");

		String urlOfAppiumServer = "http://127.0.0.1:4723";
		URL appiumServerUrl = new URL(urlOfAppiumServer);

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel");
		options.setApp("C:\\Users\\Kiran\\eclipse-workspace\\appiumTraining\\appium\\src\\test\\resources\\ApiDemos-debug.apk");

		System.out.println("Starting Aplication");
		driver = new AndroidDriver(appiumServerUrl, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
		System.out.println("Quitting Application");
		driver.quit();
		System.out.println("Stopping Appium Server Now...");
		service.stop();

		System.out.println("Appium Server Stopped");

	}

}
