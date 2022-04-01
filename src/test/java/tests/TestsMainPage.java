package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import steps.StepsMainPage;
import static com.codeborne.selenide.Selenide.*;

public class TestsMainPage {

    private StepsMainPage stepsMainPage = new StepsMainPage();

    @Test
    public void checkHeaderOnMainPage(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.checkThatButtonStatusOrderIsDisplayed();
        stepsMainPage.checkThatButtonStatusOrderIsEnabled();
        stepsMainPage.checkThatButtonRegistrationIsDisplayed();
        stepsMainPage.checkThatButtonRegistrationIsEnabled();
        stepsMainPage.checkThatButtonComparisonIsDisplayed();
        stepsMainPage.checkThatButtonComparisonIsNotEnabled();
        stepsMainPage.checkThatButtonFavoritesIsDisplayed();
        stepsMainPage.checkThatButtonFavoritesIsNotEnabled();
        stepsMainPage.checkThatButtonAddToCartIsDisplayed();
        stepsMainPage.checkThatButtonAddToCartIsNotEnabled();
        closeWebDriver();
    }

    @Test
    public void checkCartButtonActivation(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.checkThatBlockWithProductDayIsDisplayed();
        stepsMainPage.clickOnButtonAddToCartProductDay();
        stepsMainPage.checkNumberOnTheCartDisplayed();
        stepsMainPage.checkThatButtonAddToCartProductDayIsEnabled();
        closeWebDriver();
    }

    @Test
    public void checkClientAuthorizationModalWindow(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.checkThatButtonRegistrationIsDisplayed();
        stepsMainPage.clickOnButtonRegistration();
        stepsMainPage.checkThatFormRegistrationIsDisplayed();
        stepsMainPage.checkThatTitleLoginOrRegistrationIsDisplayed();
        stepsMainPage.checkThatPhoneInputFieldIsDisplayed();
        stepsMainPage.checkThatButtonContinueIsNotEnabled();
        stepsMainPage.checkThatLinkLegalEntitiesIsDisplayed();
        closeWebDriver();

    }

    @Test
    public void checkCityChange(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.clickOnLocationButton();
        stepsMainPage.checkThatWindowSelectCityIsDisplayed();
        stepsMainPage.selectDesiredCity("Краснодар");
        stepsMainPage.displayTitleToCheckPageLoading();
        stepsMainPage.modalWindowIsntDisplay();
        stepsMainPage.checkDisplayedLocator("Краснодар");



    }
}
