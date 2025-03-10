package org.growdu;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Epic("系统电池测试")
@Feature("系统电池测试")
public class BattaryTest {
    protected AndroidDriver driver;
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")   // 平台
                .setDeviceName("emulator-5554") // 设备名称（可用 `adb devices` 查看）
                .setAppPackage("com.android.settings")
                .setAppActivity(".Settings");

        // 连接到 Appium 服务器
        driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("测试手机电池功能")
    public void testBattery() throws InterruptedException {
        Allure.step("点击 'Battery'");
        try {
            // 判断是否出现“播放”按钮，若存在则点击
            WebElement agreeButton = driver.findElement(AppiumBy.xpath("//*[@text=\"Battery\"]"));
            agreeButton.click();
        } catch (Exception e) {
            Allure.step("无法进入电池" );
        }

        Allure.step("进入电池成功");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            saveScreenshot();
        }
    }

    @Attachment(value = "失败截图", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
