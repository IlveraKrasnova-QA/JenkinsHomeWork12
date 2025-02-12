package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        String browser = System.getenv("BROWSER");
        Configuration.browser = browser != null ? browser : "mozilla";
        String browserversion = System.getenv("BROWSER_VERSION");
        Configuration.browserVersion = browserversion != null ? browserversion : "124.0";
        String browsersize = System.getenv("BROWSER_SIZE");
        Configuration.browserSize = browsersize != null ? browsersize : "1928x1080";

        String remote = System.getenv("REMOTE_DRIVER_URL");
        String baseUrl = "https://user1:1234@" + (remote != null && !remote.isEmpty() ? remote : "selenoid.autotests") + "/wd/hub";
        Configuration.baseUrl = baseUrl;

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        Selenide.closeWebDriver();
    }
}
