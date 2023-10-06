package tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.SearchPage;

import java.util.List;
import java.util.stream.Stream;

public class MainPageTest extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    private String url = "/";

    @ParameterizedTest(name = "При успешном поиске {0} на странице поиска отображается заголовок {1}")
    @Tags({@Tag("UI"), @Tag("Search"), @Tag("Smoke")})
    @CsvSource(value = {
            "молоко, Вот что мы нашли по запросу «молоко»",
            "пицца, Вот что мы нашли по запросу «пицца»",
            "сыр, Вот что мы нашли по запросу «сыр»",
            "семечки, Вот что мы нашли по запросу «семечки»"
    })
    public void searchTest(String searchValue, String headerResult) {
        mainPage.openMainPage(url)
                .searchValue(searchValue);

        searchPage.checkResult(headerResult);
    }

    static Stream<List> catalogContentTest() {
        return Stream.of(List.of(MainPage.catalogElements));
    }
    @MethodSource
    @ParameterizedTest(name = "В каталоге отображаются все записи")
    @Tags({@Tag("UI"), @Tag("Catalog"), @Tag("Smoke")})
    public void catalogContentTest(List<String> catalogElements) {
        mainPage.openMainPage(url);

        mainPage.getCatalog().shouldHave(CollectionCondition.texts(catalogElements));

    }

    @ParameterizedTest
    @DisplayName("При поиске боковая панель корзины скрыта")
    @Tags({@Tag("UI"), @Tag("Cart"), @Tag("Regress")})
    @ValueSource(strings = {"детское питание", "йогурт"})
    public void checkCartTest(String searchValue) {
        mainPage.openMainPage(url)
                .searchValue(searchValue);

        searchPage.checkCartHidden();
    }
}
