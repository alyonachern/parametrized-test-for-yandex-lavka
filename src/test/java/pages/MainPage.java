package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement sidebar = $(".w1ucdt7p"),
            searchBar = $("#search-input-id");

    private ElementsCollection catalog = $$("#root nav");
    public static String[] catalogElements = {
            "Каталог\n" +
                    "Рецепты Лавки\n" +
                    "Придумано Яндекс Лавкой\n" +
                    "Всё «\u200EИз Лавки»\u200E\n" +
                    "Новое\n" +
                    "Выбираем вместе\n" +
                    "Готовая еда\n" +
                    "Фуд-корт Лавки\n" +
                    "Основное меню\n" +
                    "Пекарня и кондитерская\n" +
                    "Кофейня\n" +
                    "Овощной прилавок\n" +
                    "Овощи, грибы и зелень\n" +
                    "Фрукты и ягоды\n" +
                    "Молочный прилавок\n" +
                    "Молоко, масло и яйца\n" +
                    "Сыры\n" +
                    "Кефир, сметана, творог\n" +
                    "Йогурты и десерты\n" +
                    "Молочное для детей\n" +
                    "Булочная\n" +
                    "Хлеб\n" +
                    "Выпечка\n" +
                    "Хлебцы\n" +
                    "Вода и напитки\n" +
                    "Вода\n" +
                    "Соки и морсы\n" +
                    "Газировка и тоники\n" +
                    "Холодный чай и кофе\n" +
                    "Энергетики, пиво и вино\n" +
                    "Сладкое и снеки\n" +
                    "Снеки\n" +
                    "Шоколад и конфеты\n" +
                    "Торты, печенье, вафли\n" +
                    "Сухофрукты и орехи\n" +
                    "Пастила и мармелад\n" +
                    "Варенье, мёд и пасты\n" +
                    "Леденцы и жвачка\n" +
                    "Мясо, птица, рыба\n" +
                    "Мясо и птица\n" +
                    "Колбаса и сосиски\n" +
                    "Рыба и морепро\u00ADдукты\n" +
                    "Закуски и паштеты\n" +
                    "Заморозка\n" +
                    "Мороженое\n" +
                    "Пельмени и вареники\n" +
                    "Овощи и ягоды\n" +
                    "Десерты\n" +
                    "Полуфабрикаты\n" +
                    "Рыба и морепро\u00ADдукты\n" +
                    "Лёд и кое-что ещё\n" +
                    "Здоровый образ жизни\n" +
                    "Без мя\u00ADса и мо\u00ADло\u00ADка\n" +
                    "Вкусно и полезно\n" +
                    "Вода и напитки\n" +
                    "Спорт\n" +
                    "Без глю\u00ADте\u00ADна\n" +
                    "Бакалея\n" +
                    "Макароны, крупы и мука\n" +
                    "Сухие завтраки и каши\n" +
                    "Масло, соусы и специи\n" +
                    "Кофе и какао\n" +
                    "Чай\n" +
                    "Консервы\n" +
                    "Для детей\n" +
                    "Питание\n" +
                    "Вода и напитки\n" +
                    "Гигиена и уход\n" +
                    "Для животных\n" +
                    "Для кошек\n" +
                    "Для собак\n" +
                    "Дом, милый дом\n" +
                    "Гигиена\n" +
                    "Бумага и салфетки\n" +
                    "Уборка и стирка\n" +
                    "Косметика и уход\n" +
                    "Полезные мелочи\n" +
                    "Батарейки и лампочки\n" +
                    "Для готовки и хранения\n" +
                    "Очень надо\n" +
                    "Аптечка\n" +
                    "Магазин Яндекса\n" +
                    "Носки и колготки\n" +
                    "Всё для пикника и вечеринки\n" +
                    "Для школы и офиса"
    };

    public SelenideElement getSidebarElement(String element) {
        return sidebar.$(byTagAndText("span", element));
    }

    public MainPage clickSideBarElement(String element) {
        getSidebarElement(element).click();
        return this;
    }

    public MainPage openMainPage(String url) {
        open(url);
        return this;
    }

    public SearchPage searchValue(String string) {
        searchBar.click();
        searchBar.setValue(string).pressEnter();
        return new SearchPage();
    }

    public ElementsCollection getCatalog() {
        return catalog;
    }
}