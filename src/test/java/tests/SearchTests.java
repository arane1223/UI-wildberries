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
                .clickOnSearchInput()
                .clickOnSearchInput()
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
        String text = "Ввод в строку";

        mainPage
                .openMainPage()
                .setValueOnSearchInputAndPressEnter(text);

        catalogPage.checkingSearchInputValue(text)
                .checkingFirstHeading(text);
    }

    @Test
    @DisplayName("При вводе в поиске на английской раскладке результат меняется на русскую")
    void whenSetValueInSearchInputWithIncorrectKeyboardLayoutThenValueSwitchToCorrectLayout() {
        String text = "Yfcnjkmyst buhs";

        mainPage
                .openMainPage()
                .setValueOnSearchInputAndPressEnter(text);

        catalogPage
                .checkingSearchInputValue(enToRu(text))
                .checkingSearchResultText(text)
                .checkingFirstHeading(enToRu(text));
    }

    @Test
    @DisplayName("Если ввести значение в поисковую строку и нажать на крестик, строка очистится")
    void whenSetValueInInputSearchAndClickOnClearButtonThenValueWillDeleted() {
        String text = "Какой-то текст";

        mainPage
                .openMainPage()
                .setValueOnSearchInput(text)
                .clickOnClearSearchValueButton()
                .checkingSearchInputValue(text);
    }
}
