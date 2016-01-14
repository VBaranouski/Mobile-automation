import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import properties.IOSsimulator;

import java.net.MalformedURLException;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


/**
 * Created by Vlad on 12/8/15.
 */
public class iOSsimulatorTest {

    private final static Logger lOGGER = Logger.getLogger(String.valueOf(iOSsimulatorTest.class));


    @Test
    public void testOnSimulator() throws MalformedURLException {
        AppiumDriver driver = IOSsimulator.runIOSsimulator();
        driver.findElement(By.name("TextField1")).sendKeys("5");
        driver.findElement(By.name("TextField2")).sendKeys("9");
        driver.findElement(By.name("ComputeSumButton")).click();
        lOGGER.info("Addition of two numbers...");
        String result = driver.findElement(By.name("Answer")).getText();
        assertEquals("14",result);
        lOGGER.info("Result is correct");
        System.out.println(result);
        IOSsimulator.closeSimulator();

    }

}
