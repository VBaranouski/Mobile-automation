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
public class IOSsimulator {


    public static AppiumDriver driver;

    private final static Logger lOGGER = Logger.getLogger(String.valueOf(IOSsimulator.class));
    private static String appPath = "/Users/Vlad/Documents/TestApp.app";


    public static void closeSimulator(){
        driver.quit();
        driver = null;
        lOGGER.info("Simulator closed");
    }


    public static AppiumDriver runIOSsimulator() throws MalformedURLException {
        if(null == driver) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium-version", "1.4.13");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "9.2");
            capabilities.setCapability("deviceName", "iPhone 6");
            capabilities.setCapability("app", appPath);
            driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        lOGGER.info("Simulator is started");
        return driver;
    }


}
