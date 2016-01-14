package properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by Vlad on 1/6/16.
 */
public class AndroidEmulator {

    public static AppiumDriver driver;

    private final static Logger lOGGER = Logger.getLogger(String.valueOf(IOSsimulator.class));
    private static String appPath = "/Users/Vlad/Downloads/net.tecnotopia.SimpleCalculator.apk";


    public static void closeEmulator(){
        driver.quit();
        driver = null;
        lOGGER.info("Emulator closed");
    }


    public static AppiumDriver runAndroidEmulator() throws MalformedURLException {
        if(null == driver) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium-version", "1.0");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "5.1");
            capabilities.setCapability("deviceName", "Samsung S5");
            capabilities.setCapability("app", appPath);

            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        }

        lOGGER.info("Simulator is started");
        return driver;
    }
}
