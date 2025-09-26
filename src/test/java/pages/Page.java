package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Page {
    protected SelenideElement
            searchInput = $("#searchInput"),
            navigationMenuBurger = $(".nav-element__burger"),
            autocompleteContent = $(".autocomplete__content"),
            firstHeading = $("h1"),
            searchByImage = $("#searchByImageFormAbNew"),
            clearSearchValueButton = $(".search-catalog__btn--clear");
}
