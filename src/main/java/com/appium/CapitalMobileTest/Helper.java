package com.appium.CapitalMobileTest;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;   //To find a dependency for it
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.api.ImageTarget;                          
import org.sikuli.api.ScreenRegion;                        
import org.sikuli.api.StaticImageScreenRegion;                 
import org.sikuli.api.Target;                                     
/*
public abstract class Helper {
	
	public static String sharedData = "";
	
	public AppiumDriver driver;
    DriverProvider driverProvider;
    int timeoutInSeconds;

    public Helper(DriverProvider driverPorvider) {
        this.driverProvider = driverPorvider;
        this.timeoutInSeconds = 60;
//        if (SauceLabeSessionHandler.getRunOnSauce()) {
//            this.timeoutInSeconds = 120;
//        }

    }

    public void scrollTo(String elementSelector) {
        boolean found = false;
        int screenHeight = this.currentDriver().manage().window().getSize().getHeight();
        int screenWidth = this.currentDriver().manage().window().getSize().getWidth();

        while(!found) {
            this.currentDriver().swipe((int)((double)screenWidth * 0.5D), (int)((double)screenHeight * 0.9D), (int)((double)screenWidth * 0.5D), 0, 2000);

            try {
                if (this.find(elementSelector).isDisplayed()) {
                    found = true;
                    MobileElement ele = this.find(elementSelector);

                    while((double)ele.getLocation().getY() > (double)screenHeight * 0.2D) {
                        int previousValue = ele.getLocation().getY();
                        this.currentDriver().swipe((int)((double)screenWidth * 0.5D), (int)((double)screenHeight * 0.5D), (int)((double)screenWidth * 0.5D), (int)((double)screenHeight * 0.4D), 2000);
                        ele = this.find(elementSelector);
                        if (previousValue == ele.getLocation().getY()) {
                            break;
                        }
                    }
                }
            } catch (Exception var7) {
            }
        }

    }

    public void scrollToWithCount(String elementSelector, int count) {
        boolean found = false;
        int screenHeight = this.currentDriver().manage().window().getSize().getHeight();
        int screenWidth = this.currentDriver().manage().window().getSize().getWidth();
        int timesEntered = 0;

        while(!found) {
            ++timesEntered;
            if (timesEntered - 1 == count) {
                throw new ElementNotFoundException(elementSelector, "", "");
            }

            this.currentDriver().swipe((int)((double)screenWidth * 0.5D), (int)((double)screenHeight * 0.9D), (int)((double)screenWidth * 0.5D), 0, 2000);

            try {
                if (this.find(elementSelector).isDisplayed()) {
                    found = true;
                    MobileElement ele = this.find(elementSelector);

                    while((double)ele.getLocation().getY() > (double)screenHeight * 0.2D) {
                        int previousValue = ele.getLocation().getY();
                        this.currentDriver().swipe((int)((double)screenWidth * 0.5D), (int)((double)screenHeight * 0.5D), (int)((double)screenWidth * 0.5D), (int)((double)screenHeight * 0.4D), 2000);
                        ele = this.find(elementSelector);
                        if (previousValue == ele.getLocation().getY()) {
                            break;
                        }
                    }
                }
            } catch (Exception var9) {
            }
        }

    }

    public void SwipeRight() {
        int screenHeight = this.currentDriver().manage().window().getSize().getHeight();
        int screenWidth = this.currentDriver().manage().window().getSize().getWidth();
        this.currentDriver().swipe((int)((double)screenWidth * 0.1D), (int)((double)screenHeight * 0.5D), (int)((double)screenWidth * 0.99D), (int)((double)screenHeight * 0.5D), 1000);
    }

    public void SwipeLeft() {
        int screenHeight = this.currentDriver().manage().window().getSize().getHeight();
        int screenWidth = this.currentDriver().manage().window().getSize().getWidth();
        this.currentDriver().swipe((int)((double)screenWidth * 0.8D), (int)((double)screenHeight * 0.5D), 0, (int)((double)screenHeight * 0.5D), 500);
    }

    private MobileElement w(WebElement element) {
        return (MobileElement)element;
    }

    public void sleepTime(int value) {
        try {
            Thread.currentThread();
            Thread.sleep((long)value);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public AppiumDriver currentDriver() {
        return this.driverProvider.getCurrentDriver();
    }

    private List<MobileElement> w(List<WebElement> elements) {
        List<MobileElement> list = new ArrayList(elements.size());
        Iterator var3 = elements.iterator();

        while(var3.hasNext()) {
            WebElement element = (WebElement)var3.next();
            list.add(this.w(element));
        }

        return list;
    }

    public void setWait(int seconds) {
        this.driverProvider.getCurrentDriver().manage().timeouts().implicitlyWait((long)seconds, TimeUnit.SECONDS);
    }

    public MobileElement element(By locator) {
        return this.w(this.driverProvider.getCurrentDriver().findElement(locator));
    }

    public List<MobileElement> elements(By locator) {
        return this.w(this.driverProvider.getCurrentDriver().findElements(locator));
    }

    public void back() {
        this.driverProvider.getCurrentDriver().navigate().back();
    }

    public List<MobileElement> tags(String tagName) {
        return this.elements(this.for_tags(tagName));
    }

    public By for_tags(String tagName) {
        return By.className(tagName);
    }

    public MobileElement s_text(int xpathIndex) {
        return this.element(this.for_text(xpathIndex));
    }

    public By for_text(int xpathIndex) {
        return By.xpath("//android.widget.TextView[" + xpathIndex + "]");
    }

    public MobileElement text(String text) {
        return this.element(this.for_text(text));
    }

    public By for_text(String text) {
        return By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]");
    }

    public MobileElement text_exact(String text) {
        return this.element(this.for_text_exact(text));
    }

    public By for_text_exact(String text) {
        return By.xpath("//android.widget.TextView[@text='" + text + "']");
    }

    public By for_find(String value) {
        return By.xpath("//*[@content-desc=\"" + value + "\" or @type=\"" + value + "\" or @class=\"" + value + "\" or @package=\"" + value + "\" or @resource-id=\"" + value + "\" or @text=\"" + value + "\"] | //*[contains(translate(@content-desc,\"" + value + "\",\"" + value + "\"), \"" + value + "\") or contains(translate(@text,\"" + value + "\",\"" + value + "\"), \"" + value + "\") or @resource-id=\"" + value + "\"]");
    }

    public By for_first_attribute(String value) {
        return By.xpath("(//*[@*=\"" + value + "\"])[1]");
    }

    public By for_attribute(String value) {
        return By.xpath("(//*[@*=\"" + value + "\"])");
    }

    public By for_path(String value) {
        return By.xpath(value);
    }

    public MobileElement find(String value) {
        return this.element(this.for_find(value));
    }

    public MobileElement for_tag(String value, String tag) {
        try {
            List<MobileElement> elements = this.waitAll(this.for_attribute(value));
            Iterator var4 = elements.iterator();

            MobileElement mobileElement;
            do {
                if (!var4.hasNext()) {
                    return null;
                }

                mobileElement = (MobileElement)var4.next();
            } while(!mobileElement.getTagName().equals(tag));

            mobileElement.click();
            return mobileElement;
        } catch (Exception var6) {
            return null;
        }
    }

    public WebElement findElement(String value) {
        return this.driverProvider.getCurrentDriver().findElement(this.for_find(value));
    }

    public WebElement findElementByName(String value) {
        return this.driverProvider.getCurrentDriver().findElement(By.name(value));
    }

    public void hideKeyboard() {
        this.driverProvider.getCurrentDriver().hideKeyboard();
    }

    public MobileElement wait(By locator) {
        WebDriverWait driverWait = new WebDriverWait(this.driverProvider.getCurrentDriver(), (long)this.timeoutInSeconds);
        return this.w((WebElement)driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public List<MobileElement> waitAll(By locator) {
        WebDriverWait driverWait = new WebDriverWait(this.driverProvider.getCurrentDriver(), (long)this.timeoutInSeconds);
        return this.w((List)driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
    }

    public boolean waitInvisible(By locator) {
        WebDriverWait driverWait = new WebDriverWait(this.driverProvider.getCurrentDriver(), (long)this.timeoutInSeconds);
        return (Boolean)driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

//    public MobileElement scroll_to(String value) {
//        return (MobileElement)this.driverProvider.getCurrentDriver().scroll_to(value);
//    }
//
//    public MobileElement scroll_to_exact(String value) {
//        return (MobileElement)this.driverProvider.getCurrentDriver().scrollToExact(value);
//    }

    public List<WebElement> webElements(By locator) {
        return this.driverProvider.getCurrentDriver().findElements(locator);
    }

    public int findElementsCount(String value) {
        return this.driverProvider.getCurrentDriver().findElements(this.for_find(value)).size();
    }

    public void setSharedData(String value) {
        sharedData = value;
    }

    public String getSharedData() {
        return sharedData;
    }

    public void clickOnImage(String imageName) {
        String workingDir = System.getProperty("user.dir");
        String path = File.separator + workingDir + File.separator + "imgs" + File.separator + imageName;
        ScreenRegion reg = this.getRegion(path);
        TouchAction t = new TouchAction(this.currentDriver());
        t.tap(reg.getCenter().getX(), reg.getCenter().getY());
        t.perform();
    }

    public void checkByImage(String imageName) {
        String workingDir = System.getProperty("user.dir");
        String path = File.separator + workingDir + File.separator + "imgs" + File.separator + imageName;
        ScreenRegion reg = this.getRegion(path);
        TouchAction t = new TouchAction(this.currentDriver());
        t.tap(reg.getCenter().getX(), reg.getCenter().getY());
    }

    public ScreenRegion getRegion(String targetFileLocation) {
        int counter = 5;
        boolean notDone = true;
        if (targetFileLocation == null) {
            System.err.println(" no target file name");

            try {
                Thread.sleep(100L);
            } catch (Exception var6) {
            }

            return null;
        } else if ((new File(targetFileLocation)).exists() && !(new File(targetFileLocation)).isDirectory()) {
            while(true) {
                try {
                    ScreenRegion region = this.findRegion(targetFileLocation);
                    region.getCenter();
                    notDone = false;
                    return region;
                } catch (Exception var9) {
                    System.err.println(" no target image found in shot. retrying...");

                    try {
                        Thread.sleep(200L);
                    } catch (Exception var7) {
                    }

                    if (counter-- <= 0 || !notDone) {
                        return null;
                    }
                }
            }
        } else {
            System.err.println(" file not exits: " + targetFileLocation);

            try {
                Thread.sleep(100L);
            } catch (Exception var8) {
            }

            return null;
        }
    }

    public ScreenRegion findRegion(String targetFileLocation) {
        Target target = new ImageTarget(new File(targetFileLocation));
        target.setMinScore(0.9D);
        ScreenRegion screenRegion = (new StaticImageScreenRegion(this.takeShot())).find(target);
        return screenRegion;
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, 4);
        BufferedImage dimg = new BufferedImage(newW, newH, 2);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, (ImageObserver)null);
        g2d.dispose();
        return dimg;
    }

    public BufferedImage takeShot() {
        for(int i = 0; i < 5; ++i) {
            if (this.currentDriver().manage().window().getSize().getHeight() > this.currentDriver().manage().window().getSize().getWidth()) {
                System.out.println("   takeShot: portrait mode w: " + this.currentDriver().manage().window().getSize().getWidth() + ", h: " + this.currentDriver().manage().window().getSize().getHeight());

                try {
                    Dimension dat = this.currentDriver().manage().window().getSize();
                    BufferedImage img = ImageIO.read((File)this.currentDriver().getScreenshotAs(OutputType.FILE));
                    img = resize(img, this.currentDriver().manage().window().getSize().getWidth(), this.currentDriver().manage().window().getSize().getHeight());
                    File outputfile = new File("saved.png");
                    ImageIO.write(img, "png", outputfile);
                    return img;
                } catch (Exception var7) {
                }
            } else {
                System.out.println("   takeShot: landscape mode w: " + this.currentDriver().manage().window().getSize().getWidth() + ", h: " + this.currentDriver().manage().window().getSize().getHeight());
                BufferedImage image = null;

                try {
                    image = ImageIO.read((File)this.currentDriver().getScreenshotAs(OutputType.FILE));
                } catch (Exception var6) {
                    System.err.println("    get screenshot failed.");
                }

                if (image != null) {
                    int diff = image.getHeight() - image.getWidth();
                    diff /= 2;
                    AffineTransform tx = new AffineTransform();
                    tx.rotate(4.71238898038469D, (double)(image.getHeight() / 2), (double)(image.getWidth() / 2));
                    AffineTransformOp op = new AffineTransformOp(tx, 2);
                    image = op.filter(image, (BufferedImage)null);
                    image = image.getSubimage(diff, diff, image.getWidth() - diff, image.getHeight() - diff);
                    return image;
                }
            }
        }

        return null;
    }

    public void isAds() {
        try {
            this.clickOnImage("x.PNG");
        } catch (Exception var2) {
        }

    }

    public void clickByImage(String imageName) {
        this.clickOnImage(imageName);
    }

    public void iOSAds() {
        try {
            this.clickByImage("close.png");
        } catch (Exception var2) {
        }

    }
    
//    public AppiumDriver mydriver() {
//
//	DesiredCapabilities capabilities = new DesiredCapabilities();
//    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, EnvirommentManager.getInstance().getProperty("AndroidDeviceName"));
//    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, EnvirommentManager.getInstance().getProperty("platformName"));
//    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,EnvirommentManager.getInstance().getProperty("platformVersion"));        
//    capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+File.separator+"app"+File.separator+"build"+File.separator+"outputs"+File.separator+"apk"+File.separator+EnvirommentManager.getInstance().getProperty("AndroidAppFileName"));
//    capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION,EnvirommentManager.getInstance().getProperty("platformVersion"));
//    capabilities.setCapability(MobileCapabilityType.NO_RESET, EnvirommentManager.getInstance().getProperty("resetApp"));
//    capabilities.setCapability(MobileCapabilityType.FULL_RESET, EnvirommentManager.getInstance().getProperty("fullreset"));       
//    if (driver == null) {
//    	driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }
//    
//    
//    
	
	

}*/
