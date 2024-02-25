package steps;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class MyStepdefs {
    private static WebDriver driver;

    @Given("As an end user I want to open the WebdriverIO application on my android device")
    public void as_an_end_user_i_want_to_open_the_webdriver_io_application_on_my_android_device() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\pratikal\\Desktop\\wdio.apk");
        capabilities.setCapability(PLATFORM_VERSION, "12");
        capabilities.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        Thread.sleep(5000);
        System.out.println("Application started");
    }
    @When("I navigate to Login page and enter the credentials")
    public void i_navigate_to_login_page_and_enter_the_credentials() throws InterruptedException {

        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Login\"]")).click();
        Thread.sleep(7000);
        System.out.println("Sending user credentials");
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-email\"]")).sendKeys("pratikshapk101@gmail.com");
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-password\"]")).sendKeys("happynewyear24");
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"LOGIN\"]")).click();
        Thread.sleep(3000);
    }


    @Then("I should be able to login successfully")
    public void I_should_be_able_to_login_successfully() throws InterruptedException {
        Boolean Display = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).isDisplayed();
        System.out.println("Element displayed is :" + Display);
        System.out.println("User registration completed");
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
        Thread.sleep(2000);
        driver.quit();
    }


}





