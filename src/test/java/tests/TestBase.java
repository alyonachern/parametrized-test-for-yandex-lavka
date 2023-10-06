package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://lavka.yandex.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1600x900";
        Configuration.holdBrowserOpen = false;
    }
}
