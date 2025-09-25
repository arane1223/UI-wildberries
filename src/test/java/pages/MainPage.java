package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    protected SelenideElement
            searchCategories = $(".p9n_29"),
            searchBar = $(".rn0_29");

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("/");
        return this;
    }
}
