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
        searchInput
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Дважды кликнуть на строку поиска")
    public MainPage doubleClickOnSearchInput() {
        searchInput
                .shouldBe(visible)
                .doubleClick();
        return this;
    }

    @Step("Ввести текст в строку поиска и нажать на Enter")
    public MainPage setValueOnSearchInput(String value) {
        searchInput
                .shouldBe(visible)
                .setValue(value);
        return this;
    }

    @Step("Ввести текст в строку поиска и нажать на Enter")
    public MainPage setValueOnSearchInputAndPressEnter(String value) {
        searchInput
                .shouldBe(visible)
                .setValue(value)
                .pressEnter();
        return this;
    }

    @Step("Проверить, что всплывающее окно не видно")
    public MainPage checkThatAutocompleteContentInvisible() {
        autocompleteContent
                .shouldNotBe(visible);
        return this;
    }

    @Step("Проверить строку в сплывающем списке поиска")
    public MainPage checkAutocompleteContent(String value) {
        autocompleteContent
                .shouldBe(visible)
                .shouldHave(text(value));
        return this;
    }

    @Step("Нажать на крестик справа в поисковой строке")
    public MainPage clickOnClearSearchValueButton() {
        clearSearchValueButton
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Проверить значение в строке поиска в каталоге")
    public MainPage checkingSearchInputValue(String value) {
        searchInput
                .shouldNotHave(value(value));
        return this;
    }

    @Step("Кликнуть в поиске на иконку с поиском по картинке")
    public MainPage clickOnSearchByImage() {
        searchByImage
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Проверить заголовок в поп-апе для поиска оп картинкам")
    public MainPage checkingSearchPyImagePopUp(String heading) {
        searchByImagePopUp.shouldBe(visible).shouldHave(text(heading));
        return this;
    }

    @Step("Нажать на кнопку и загрузить картинку")
    public MainPage setPictureForSearching(String picture) {
        searchByImage
                .shouldBe(visible)
                .click();
        popUpFileInput.uploadFromClasspath(picture);
        return this;
    }

    @Step("Проверить, что открылся поп-ап с выбором области товара")
    public MainPage checkingPopUpWithUploadImage(String heading) {
        popUpWithUploadImage
                .shouldBe(visible);
        popUpWithUploadImageHeader
                .shouldHave(text(heading));
        return this;
    }
}
