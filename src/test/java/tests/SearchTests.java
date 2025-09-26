package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static utils.KeyboardSwitch.enToRu;

@DisplayName("Тесты на строку поиска")
public class SearchTests extends TestBase {

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
        String getText = "Ввод в строку";

        mainPage
                .openMainPage()
                .setValueOnSearchInputAndPressEnter(getText);

        catalogPage
                .checkingSearchInputValue(getText)
                .checkingFirstHeading(getText);
    }

    @Test
    @DisplayName("При вводе в поиске на английской раскладке результат меняется на русскую")
    void whenSetValueInSearchInputWithIncorrectKeyboardLayoutThenValueSwitchToCorrectLayout() {
        String getText = "Yfcnjkmyst buhs";

        mainPage
                .openMainPage()
                .setValueOnSearchInputAndPressEnter(getText);

        catalogPage
                .checkingSearchInputValue(enToRu(getText))
                .checkingSearchResultText(getText)
                .checkingFirstHeading(enToRu(getText));
    }

    @Test
    @DisplayName("Если ввести значение в поисковую строку и нажать на крестик, строка очистится")
    void whenSetValueInInputSearchAndClickOnClearButtonThenValueWillDeleted() {
        String getText = "Какой-то текст";

        mainPage
                .openMainPage()
                .setValueOnSearchInput(getText)
                .clickOnClearSearchValueButton()
                .checkingSearchInputValue(getText);
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
        String getPicture = "man-in-jacket.jpeg";

        mainPage
                .openMainPage()
                .setPictureForSearching(getPicture)
                .checkingPopUpWithUploadImage("Выберите область с товаром");
    }
}
