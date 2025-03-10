package org.growdu;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

@Epic("QQ音乐 App 测试")
@Feature("登录功能测试")
public class QQMusicLoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(QQMusicLoginTest.class);

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("测试 QQ 音乐 App 登录功能")
    public void testQQMusicLogin() {
        Allure.step("点击 '我的' 按钮");
        try {
            // 判断是否出现“播放”按钮，若存在则点击
            WebElement agreeButton = driver.findElement(AppiumBy.xpath("//*[@text=\"我的\"]"));
            agreeButton.click();
            // 登录成功后等待主页加载
            Thread.sleep(100);
        } catch (Exception e) {
            Allure.step("无法进入我的界面" );
        }
        Allure.step("点击立即登录按钮准备登录");
        try {
            // 判断是否出现“播放”按钮，若存在则点击
            WebElement agreeButton = driver.findElement(AppiumBy.xpath("//*[@text=\"立即登录\"]"));
            agreeButton.click();

        } catch (Exception e) {
            logger.warn("无法找到点击登录" );
        }
        Allure.step("点击微信登录按钮准备登录");
        try {
            // 判断是否出现“播放”按钮，若存在则点击
            WebElement agreeButton = driver.findElement(AppiumBy.xpath("//*[@text=\"微信登录\"]"));
            agreeButton.click();
        } catch (Exception e) {
            logger.warn("无法找到微信登录" );
        }

        Allure.step("登录准备结束");
    }
}
