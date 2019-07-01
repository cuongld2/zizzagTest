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

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 5X API 28");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.instagram.android");
        caps.setCapability("appActivity","com.instagram.android.activity.MainTabActivity");
        caps.setCapability("noReset","false");
        caps.setCapability("automationName","uiAutomator2");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void signUpInstaTest () throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.instagram.android:id/sign_up_with_email_or_phone"))).click();

        Assert.assertNotNull(driver.getContext());
    }

    @Test
    public void loginInstaTest (){

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.instagram.android:id/log_in_button"))).click();

        Assert.assertNotNull(driver.getContext());

    }

    @Test
    public void loginInstaWithFbAccountTest(){



    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }



}
