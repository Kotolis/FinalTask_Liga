package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.StepsMainPage;
import static com.codeborne.selenide.Selenide.*;

public class TestsMainPage {

    private StepsMainPage stepsMainPage = new StepsMainPage();

    @Epic("Тесты для проверки сайта mvideo")
    @Feature("Проверки главной страницы и шапки сайта")
    @Test(testName = "Проверка шапки главной страницы mvideo",
            description = "Проверка шапки главной страницы mvideo")
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

    @Epic("Тесты для проверки сайта mvideo")
    @Feature("Проверки главной страницы и шапки сайта")
    @Test(testName = "Проверка активации кнопки корзины",
            description = "Проверки главной страницы и шапки сайта")
    public void checkCartButtonActivation(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.checkThatBlockWithProductDayIsDisplayed();
        stepsMainPage.clickOnButtonAddToCartProductDay();
        stepsMainPage.checkNumberOnTheCartDisplayed();
        stepsMainPage.checkThatButtonAddToCartProductDayIsEnabled();
        closeWebDriver();
    }

    @Epic("Тесты для проверки сайта mvideo")
    @Feature("Проверки главной страницы и шапки сайта")
    @Test(testName = "Проверка модального окна авторизации клиента",
            description = "Проверка модального окна авторизации клиента")
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

    @Epic("Тесты для проверки сайта mvideo")
    @Feature("Проверки главной страницы и шапки сайта")
    @Test(testName = "Проверка изменения города",
            description = "Проверка изменения города")
    public void checkCityChange(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.clickOnLocationButton();
        stepsMainPage.checkThatWindowSelectCityIsDisplayed();
        stepsMainPage.selectDesiredCity("Краснодар");
        stepsMainPage.displayButtonToCheckPageLoading();
        stepsMainPage.checkDisplayedLocator("Краснодар");
        closeWebDriver();

    }

    @AfterMethod(description = "закрытие браузера")
    public void close(){
        closeWebDriver();
    }
}
