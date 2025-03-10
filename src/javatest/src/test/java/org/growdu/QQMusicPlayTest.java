package org.growdu;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Epic("QQ音乐 播放 测试")
@Feature("播放功能测试")
public class QQMusicPlayTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("测试 QQ 音乐 播放功能")
    public void testQQMusicPlay() throws InterruptedException {
        Allure.step("点击 '播放' 按钮");
        try {
            // 判断是否出现“播放”按钮，若存在则点击
            WebElement agreeButton = driver.findElement(AppiumBy.xpath("//*[@text=\"播放\"]"));
            agreeButton.click();
        } catch (Exception e) {
            Allure.step("无法播放" );
        }
        Thread.sleep(1000);
        Allure.step("播放完成");
    }
}
