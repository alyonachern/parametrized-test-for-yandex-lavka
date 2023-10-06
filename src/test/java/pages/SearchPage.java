package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {
    private String url = "/search";
    public SelenideElement content = $("#main-content-id");
    private SelenideElement cart = $("CART_POPUP_ID"),
            cartIcon = $(byText("Корзина"));

    public SearchPage openPage(String url) {
        open(url);
        return this;
    }

    public SearchPage checkResult(String result) {
        content.shouldHave(text(result));
        return this;
    }

    public SearchPage checkCartHidden() {
        cart.shouldBe(hidden);
        return this;
    }
}
