package org.growdu;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver driver;

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")   // 平台
                .setDeviceName("emulator-5554") // 设备名称（可用 `adb devices` 查看）
                .setAppPackage("com.tencent.qqmusic") // 计算器应用的包名
                .setAppActivity("com.tencent.qqmusic.activity.AppStarterActivity") // 计算器的主活动
                .setNoReset(true);  // 不重置应用数据

        // 连接到 Appium 服务器
        driver = new AndroidDriver(new URL("http://localhost:4723"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // 登录成功后等待主页加载
        try {
            // 判断是否出现“同意”按钮，若存在则点击
            WebElement agreeButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='同意']"));
            agreeButton.click();
            System.out.println("已点击同意按钮");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("没有同意按钮，不需要点击");
        }
        // 登录成功后等待主页加载
        try {
            // 判断是否出现“同意”按钮，若存在则点击
            WebElement agreeButton = driver.findElement(AppiumBy.xpath("//*[@text=\"跳过\"]"));
            agreeButton.click();
            System.out.println("已点击跳过按钮");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("没有跳过按钮，不需要执行任何操作");
        }
        try {
            // 判断是否出现“播放”按钮，若存在则点击
            WebElement agreeButton = driver.findElement(AppiumBy.xpath("//*[@text=\"播放\"]"));
            agreeButton.click();
            System.out.println("点击播放按钮开始播放歌曲");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("播放过程出错：");
        }
        try {
            // 判断是否出现“播放”按钮，若存在则点击
            WebElement agreeButton = driver.findElement(AppiumBy.xpath("//*[@text=\"我的\"]"));
            agreeButton.click();
            System.out.println("点击我的按钮准备登录");
            // 登录成功后等待主页加载
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("无法进入我的界面" );
        }
        try {
            // 判断是否出现“播放”按钮，若存在则点击
            WebElement agreeButton = driver.findElement(AppiumBy.xpath("//*[@text=\"立即登录\"]"));
            agreeButton.click();
            System.out.println("点击立即登录按钮准备登录");
            // 登录成功后等待主页加载
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("无法找到点击登录" );
        }
        try {
            // 判断是否出现“播放”按钮，若存在则点击
            WebElement agreeButton = driver.findElement(AppiumBy.xpath("//*[@text=\"微信登录\"]"));
            agreeButton.click();
            System.out.println("点击微信登录按钮准备登录");
            // 登录成功后等待主页加载
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("无法找到微信登录" );
        }
        Thread.sleep(500);
        driver.terminateApp("com.tencent.qqmusic");
        driver.quit();
    }
}