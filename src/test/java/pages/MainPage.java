package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends Page {

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("/");
        return this;
    }

    @Step("Кликнуть на строку поиска")
    public MainPage clickOnSearchInput() {
        searchInput.click();
        return this;
    }

    @Step("Ввести текст в строку поиска и нажать на Enter")
    public MainPage setValueOnSearchInput(String value) {
        searchInput.setValue(value);
        return this;
    }

    @Step("Ввести текст в строку поиска и нажать на Enter")
    public MainPage setValueOnSearchInputAndPressEnter(String value) {
        searchInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Проверить, что всплывающее окно не видно")
    public MainPage checkThatAutocompleteContentInvisible() {
        autocompleteContent.shouldNotBe(visible);
        return this;
    }

    @Step("Проверить строку в сплывающем списке поиска")
    public MainPage checkAutocompleteContent(String value) {
        autocompleteContent.shouldBe(visible);
        autocompleteContent.shouldHave(text(value));
        return this;
    }

    @Step("Нажать на крестик справа в поисковой строке")
    public MainPage clickOnClearSearchValueButton() {
        clearSearchValueButton.click();
        return this;
    }

    @Step("Проверить значение в строке поиска в каталоге")
    public MainPage checkingSearchInputValue(String value) {
        searchInput.shouldNotHave(value(value));
        return this;
    }
}
