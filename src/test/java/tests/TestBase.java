package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.MainPage;

public class TestBase {

    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.wildberries.ru";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }

    @AfterEach
    void addAttachments() {
        Selenide.closeWebDriver();
    }
}
