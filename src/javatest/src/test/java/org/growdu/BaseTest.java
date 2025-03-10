package org.growdu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")   // 平台
                .setDeviceName("emulator-5554") // 设备名称（可用 `adb devices` 查看）
                .setAppPackage("com.tencent.qqmusic") // 计算器应用的包名
                .setAppActivity("com.tencent.qqmusic.activity.AppStarterActivity") // 计算器的主活动
                .setNoReset(true);  // 不重置应用数据

        // 连接到 Appium 服务器
        driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
            driver.terminateApp("com.tencent.qqmusic");
            driver.quit();
        }
    }
}

