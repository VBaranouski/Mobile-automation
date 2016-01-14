package properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by Vlad on 12/19/15.
 */
public class IOSdevice {


    public static AppiumDriver driver;

    private final static Logger lOGGER = Logger.getLogger(String.valueOf(IOSdevice.class));
    private static String appPath = "/Users/Vlad/Documents/TestApp.app";


    public static void closeSession(){
        driver.quit();
        driver = null;
    }


    public static AppiumDriver runIOSdevice() throws MalformedURLException {
        if(null == driver) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium-version", "1.4.13");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "9.2");
            capabilities.setCapability("deviceName", "iPad 2");
            //capabilities.setCapability("orientation", "landscape");
            capabilities.setCapability("udid", "c80a1dd8daf9ca9f07261ea19e20e46a52354795");
            capabilities.setCapability("app", appPath);
            driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        lOGGER.info("App on real device is started");
        return driver;
    }


}

