package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage extends Page {

    protected SelenideElement searchResultText = $(".searching-results__text");

    @Step("Проверить значение в строке поиска в каталоге")
    public CatalogPage checkingSearchInputValue(String value) {
        searchInput.shouldHave(value(value));
        return this;
    }

    @Step("Проверить заголовок страницы в каталоге")
    public CatalogPage checkingFirstHeading(String value) {
        firstHeading.shouldHave(text(value));
        return this;
    }

    @Step("Проверить, что при вводе с некорректной раскладки написано в «Показаны результаты по запросу...»")
    public CatalogPage checkingSearchResultText(String value) {
        searchResultText.shouldHave(text(value));
        return this;
    }
}
