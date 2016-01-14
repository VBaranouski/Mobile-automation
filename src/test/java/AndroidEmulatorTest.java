import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import properties.AndroidEmulator;

import java.net.MalformedURLException;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vlad on 1/6/16.
 */
public class AndroidEmulatorTest {

    private final static Logger lOGGER = Logger.getLogger(String.valueOf(iOSsimulatorTest.class));


    @Test
    public void testOnEmulator() throws MalformedURLException {
        AppiumDriver driver = AndroidEmulator.runAndroidEmulator();
        driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.TableLayout[2]/android.widget.TableRow[4]/android.widget.Button[2]")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.TableLayout[2]/android.widget.TableRow[5]/android.widget.Button[5]")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.TableLayout[2]/android.widget.TableRow[5]/android.widget.Button[3]")).click();
        String result = driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.TableLayout[1]/android.widget.EditText[1]")).getText();
        assertEquals("3",result);
        lOGGER.info("Result is correct");
        AndroidEmulator.closeEmulator();

    }
}
