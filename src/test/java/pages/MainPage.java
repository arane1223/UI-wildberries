package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends Pages {

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

    @Step("Ввести текст в строку поиска")
    public MainPage setValueOnSearchInput(String value) {
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
}
