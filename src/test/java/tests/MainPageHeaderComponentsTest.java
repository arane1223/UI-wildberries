package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageHeaderComponentsTest extends TestBase{

    @Test
    @DisplayName("При нажатии на бургер, открывается меню")
    void menuOpenTest() {

        mainPage.openMainPage().clickOnNavigationMenuBurger();

    }
}
