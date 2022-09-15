package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xalan.lib.ExsltCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.remote.MobileCapabilityType;

public class BassClass {
	
	
	AppiumDriver<MobileElement> driver; 
	
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		
	try {
		
		/*
		////////////////// Android Capabilities //////////////////
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK built for arm64"); // sdk_gphone64_arm64  
		//caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");  // For iOS
		
		//caps.setCapability("disableAndroidWatchers", false);
		
		//caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);		
		
		//caps.setCapability("appActivity", "com.soultime.app.ui.main.ActivityMain"); // Does not work at all
		caps.setCapability("appWaitActivity", "*");
		
		caps.setCapability("appPackage", "com.backbase.retail.cboj.uat"); // It works
		         
		//caps.setCapability("appActivity", "com.backbase.model.view.activity.SplashActivity"); // It works
		caps.setCapability("baseActivity", "com.backbase.model.view.activity.BaseActivity"); // It works
		caps.setCapability("automationName", "uiautomator2");
	
	
		
		//caps.setCapability("appWaitDuration", 2000);
		
		
		// Here we set the absolute path for the apk file or ipa file
		String userDirectory = System.getProperty("user.dir");
		
		caps.setCapability(MobileCapabilityType.APP, userDirectory+"/src/test/resources/apps/app-CBOJ-OnPrem (5.6.0).apk");
		
		// caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); // This is for browser application

		
		
	
		URL	url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AppiumDriver<MobileElement>(url, caps);
		//driver.launchApp();
		////////////////// Android Capabilities end here ////////////////// */
		

		
		////////////////// iOS Capabilities //////////////////
		

		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.4");  // Try to remove iOS
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone_11"); // iOS device simulator name
		caps.setCapability(MobileCapabilityType.UDID, "F27C214C-6392-40CC-B834-36577ADB2D83");  // For iOS
		caps.setCapability("bundleId", "cboj.sit.test"); 
	
		//caps.setCapability("xcodeOrgId", "<your org id>");
		//caps.setCapability("xcodeSigningId", "<your signing id>");
		//caps.setCapability("updatedWDABundleId", "com.google.chrome.ios");
		
		
		//caps.setCapability("appWaitActivity", "*");
		
		caps.setCapability("baseActivity", "com.backbase.model.view.activity.BaseActivity"); // It works 
		caps.setCapability("automationName", "XCUITest");
		//caps.setCapability("automationName", "Instruments");
		
		
		
		// Here we set the absolute path for the apk file or ipa file
		String userDirectory = System.getProperty("user.dir");
				
		caps.setCapability(MobileCapabilityType.APP, userDirectory+"/src/test/resources/apps/CBOJ TEST IDENTITY.app");
		
		System.out.println(userDirectory+"/src/test/resources/apps/CBOJ TEST IDENTITY.app");
		URL	url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AppiumDriver<MobileElement>(url, caps);
		

		
		////////////////// iOS Capabilities end here//////////////////
		
		
}catch(Exception E) {
		
		System.out.println("///////////////Cause is: "+ E.getCause());
		System.out.println("///////////////Message is: "+ E.getMessage());
		System.out.println("///////////////StackTrace is: "+ E.getStackTrace());
		
	}

	}
	
	
	@Test
	public void firstMobileTest() throws InterruptedException {
		
		
		
		System.out.println("////// This is inside @Test /////////");
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("[class-name='android.widget.TextView'][text='Log In']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("[class-name='android.widget.EditText'][text='Enter Username']")).sendKeys("2002303");
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("[class-name='android.widget.EditText'][text='Enter Password']")).sendKeys("Pre@1234");
	
		Thread.sleep(3000);
		
		//driver.findElement(By.cssSelector("[class-name='android.widget.TextView'][text='Log In']")).click();
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView")).click();
		
		//driver.getKeyboard();
		
		Thread.sleep(2000);
		
		//((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		
		//driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "0"));

		driver.getKeyboard().sendKeys("000000");
		Thread.sleep(1000);
		driver.getKeyboard().sendKeys("000000");
		
		
	}

	



	@AfterTest
	public void tesrdown() {
		
		
		
	}
}
