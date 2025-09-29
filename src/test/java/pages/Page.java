package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Page {
    protected SelenideElement
            searchInput = $("#searchInput"),
            navigationMenuBurger = $(".nav-element__burger"),
            autocompleteContent = $(".autocomplete__content"),
            firstHeading = $("h1"),
            searchByImage = $("#searchByImageForm"),
            popUpFileInput = $("#popUpFileInput"),
            searchByImagePopUp = $("#uploadImageForSearchByImagePopUpContainer"),
            popUpWithUploadImage = $(".mo-modal__paper"),
            popUpWithUploadImageHeader = $("#headerCrop"),
            clearSearchValueButton = $(".search-catalog__btn--clear");

}
