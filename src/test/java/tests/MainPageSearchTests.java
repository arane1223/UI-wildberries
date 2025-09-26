package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static utils.KeyboardSwitch.enToRu;

@DisplayName("Тесты на строку поиска на главной странице")
public class MainPageSearchTests extends TestBase {

    @Test
    @DisplayName("При нажатии дважды на строку поиска, всплывает окно, в окне есть область «Часто ищут»")
    void whenClickOnSearchInputTwiceThenAutocompleteContentShouldBeVisible() {
        mainPage.openMainPage()
                .doubleClickOnSearchInput()
                .checkAutocompleteContent("Часто ищут");
    }

    @Test
    @DisplayName("При нажатии один раз на строку поиска, всплывающее окно не появится")
    void whenClickOnSearchInputThenAutocompleteContentShouldNotBeVisible() {
        mainPage.openMainPage()
                .clickOnSearchInput()
                .checkThatAutocompleteContentInvisible();
    }

    @Test
    @DisplayName("При вводе в поиск получается аналогичный результат в строке поиска в каталоге и заголовке")
    void whenSetValueInSearchInputThenGetSameResult() {

        mainPage
                .openMainPage()
                .setValueOnSearchInputAndPressEnter(someText);

        catalogPage
                .checkingSearchInputValue(someText)
                .checkingFirstHeading(someText);
    }

    @Test
    @DisplayName("При вводе в поиске на английской раскладке результат меняется на русскую")
    void whenSetValueInSearchInputWithIncorrectKeyboardLayoutThenValueSwitchToCorrectLayout() {

        mainPage
                .openMainPage()
                .setValueOnSearchInputAndPressEnter(incorrectKeyboardText);

        catalogPage
                .checkingSearchInputValue(enToRu(incorrectKeyboardText))
                .checkingSearchResultText(incorrectKeyboardText)
                .checkingFirstHeading(enToRu(incorrectKeyboardText));
    }

    @Test
    @DisplayName("Если ввести значение в поисковую строку и нажать на крестик, строка очистится")
    void whenSetValueInInputSearchAndClickOnClearButtonThenValueWillDeleted() {

        mainPage
                .openMainPage()
                .setValueOnSearchInput(someText)
                .clickOnClearSearchValueButton()
                .checkingSearchInputValue(someText);
    }

    @Test
    @DisplayName("При нажатии на иконку поиска по картинке, появляется поп-ап с заголовком «Найти товары по фото»")
    void whenClickSearchByPictureThenPopUpWillOpen() {

        mainPage.openMainPage()
                .clickOnSearchByImage()
                .checkingSearchPyImagePopUp("Найти товары по фото");
    }

    @Test
    @DisplayName("При загрузке картинки в поиске по картинке открывается поп-ап с выбором области товара")
    void whenUploadImageForSearchThenOpenPopUpWithProductArea() {

        mainPage
                .openMainPage()
                .setPictureForSearching(pictureForDownload)
                .checkingPopUpWithUploadImage("Выберите область с товаром");
    }
}
