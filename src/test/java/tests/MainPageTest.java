package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CatalogPage;
import pages.MainPage;
import pages.SearchPage;

import java.util.stream.Stream;

public class MainPageTest extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    CatalogPage catalogPage = new CatalogPage();

    @ParameterizedTest(name = "При успешном поиске {0} на странице поиска отображается заголовок {1}")
    @Tags({@Tag("UI"), @Tag("Search"), @Tag("Smoke")})
    @CsvSource(value = {"молоко, Вот что мы нашли по запросу «молоко»", "пицца, Вот что мы нашли по запросу «пицца»", "сыр, Вот что мы нашли по запросу «сыр»", "семечки, Вот что мы нашли по запросу «семечки»"})
    public void searchTest(String searchValue, String headerResult) {

        mainPage.openMainPage()
                .searchValue(searchValue);
        searchPage.checkResult(headerResult);
    }

    static Stream<Arguments> checkTitles() {
        return Stream.of(Arguments.of("Вам понравится", "Вам понравится"),
                Arguments.of("Придумано Яндекс Лавкой", "Всё «Из Лавки»"),
                Arguments.of("Точно хватит", "Точно хватит")
        );
    }
    @MethodSource("checkTitles")
    @ParameterizedTest(name = "По клику на пункт каталога {0} отображатеся заголовок {1}")
    @Tags({@Tag("UI"), @Tag("Catalog"), @Tag("Regress")})
    public void checkCatalogTitle(String element, String title) {

        mainPage.openMainPage()
                .getCatalogElement(element).click();
        catalogPage.checkTitle(title);

    }

    @ParameterizedTest
    @DisplayName("При поиске боковая панель корзины скрыта")
    @Tags({@Tag("UI"), @Tag("Cart"), @Tag("Regress")})
    @ValueSource(strings = {"детское питание", "йогурт"})
    public void checkCartTest(String searchValue) {

        mainPage.openMainPage()
                .searchValue(searchValue);
        searchPage.checkCartHidden();
    }
}
