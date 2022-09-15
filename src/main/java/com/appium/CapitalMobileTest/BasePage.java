package com.appium.CapitalMobileTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
//import aca.automation.util.DriverProvider;
//import aca.automation.util.EnvirommentManager;
//import aca.automation.util.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
/*
public class BasePage extends Helper {

	public static AppiumDriver driver;

	public BasePage(DriverProvider driverProvider) {
		super(driverProvider);
		// TODO Auto-generated constructor stub
	}

	public static AppiumDriverLocalService Service;

	public void startServer() throws IOException {

		String node = EnvirommentManager.getInstance().getProperty("Node");
		String appiumJS = EnvirommentManager.getInstance().getProperty("AppiumJS");
		String port = EnvirommentManager.getInstance().getProperty("port");
		String host = EnvirommentManager.getInstance().getProperty("host");

		Service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(node))
				.withAppiumJS(new File(appiumJS)).withIPAddress(host).usingPort(Integer.parseInt(port))
				.withArgument(GeneralServerFlag.LOG_LEVEL, "error").withArgument(GeneralServerFlag.SESSION_OVERRIDE));
		Service.start();
	}

	public void openApplication() throws IOException {
//driver=null;
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				EnvirommentManager.getInstance().getProperty("AndroidDeviceName"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				EnvirommentManager.getInstance().getProperty("platformName"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				EnvirommentManager.getInstance().getProperty("platformVersion"));
		capabilities.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + File.separator + "app" + File.separator + "build" + File.separator
						+ "outputs" + File.separator + "apk" + File.separator
						+ EnvirommentManager.getInstance().getProperty("AndroidAppFileName"));
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION,
				EnvirommentManager.getInstance().getProperty("platformVersion"));
		capabilities.setCapability(MobileCapabilityType.NO_RESET,
				EnvirommentManager.getInstance().getProperty("resetApp"));
		capabilities.setCapability(MobileCapabilityType.FULL_RESET,
				EnvirommentManager.getInstance().getProperty("fullreset"));

		if (driver == null) {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}else {driver.launchApp();}
	}

	public void clickonElement(String element) throws IOException {
		driver.findElement(By.id(EnvirommentManager.getInstance().getProperty(element))).click();
	}

	public void fillElement(String element, String text) {
		driver.findElement(By.id(EnvirommentManager.getInstance().getProperty(element))).sendKeys(text);
	}

}*/