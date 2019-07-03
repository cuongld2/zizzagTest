import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class zigzagTest {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("deviceName", "Nexus 5X API 28");
//        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "9.0");
//        caps.setCapability("skipUnlock","true");
//        caps.setCapability("appPackage", "com.socialnmobile.dictapps.notepad.color.note");
//        caps.setCapability("appActivity","com.socialnmobile.colornote.activity.Main");
//        caps.setCapability("noReset","false");
//        caps.setCapability("automationName","uiAutomator2");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void initialTest () throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.android.packageinstaller:id/permission_allow_button"))).click();
        Assert.assertNotNull(driver.getContext());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
