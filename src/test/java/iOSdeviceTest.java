import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import properties.IOSdevice;

import java.net.MalformedURLException;

/**
 * Created by Vlad on 12/19/15.
 */
public class iOSdeviceTest {

    @Test
    public void testOnDevice() throws MalformedURLException {
        AppiumDriver driver = IOSdevice.runIOSdevice();
        driver.findElement(By.name("TextField1")).sendKeys("5");
        driver.findElement(By.name("TextField2")).sendKeys("9");
        driver.findElement(By.name("ComputeSumButton")).click();
        IOSdevice.closeSession();

    }
}
