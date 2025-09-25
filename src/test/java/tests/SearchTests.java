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
    @DisplayName("При нажатии  один раз на строку поиска, всплывающее окно не появится")
    void whenClickOnSearchInputThenAutocompleteContentShouldNotBeVisible() {
        mainPage.openMainPage()
                .clickOnSearchInput()
                .checkThatAutocompleteContentInvisible();
    }

    @Test
    void test() {
        String text = "Ввод в строку";

        mainPage
                .openMainPage()
                .setValueOnSearchInput(text);

        catalogPage.checkingSearchInputValue(text)
                .checkingFirstHeading(text);
    }

    @Test
    @DisplayName("При вводе в поиске на некорректной раскладке результат меняется на корректную")
    void whenSetValueInSearchInputWithIncorrectKeyboardLayoutThenValueSwitchToCorrectLayout() {
        String text = "Yfcnjkmyst buhs";

        mainPage
                .openMainPage()
                .setValueOnSearchInput(text);

        catalogPage
                .checkingSearchInputValue(enToRu(text))
                .checkingSearchResultText(text)
                .checkingFirstHeading(enToRu(text));
    }
}
