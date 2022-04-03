package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.StepsBasketPage;
import steps.StepsMainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBasketPage {

   private StepsBasketPage stepsBasketPage = new StepsBasketPage();
   private StepsMainPage stepsMainPage = new StepsMainPage();

    @Epic("Тесты для проверки сайта mvideo")
    @Feature("Проверки страницы 'Корзина'")
    @Test(testName = "Переход в корзину", description = "Переход в корзину")
    public void transitionToCart(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.checkThatBlockWithProductDayIsDisplayed();
        stepsMainPage.clickOnButtonAddToCartProductDay();
        stepsMainPage.clickOnButtonBasket();
        stepsBasketPage.checkThatUrlBasketCorrect();
        stepsBasketPage.checkThatTitleBasketIsDisplayed();
        stepsBasketPage.checkThatProductInCartIsDisplayed();
        stepsBasketPage.checkThatOrderingButtonIsDisplayed();
        stepsBasketPage.checkCorrectAmountProductsInBasket();
        stepsBasketPage.checkThatPriceInOrderAndCardSame();
        closeWebDriver();
    }

    @Epic("Тесты для проверки сайта mvideo")
    @Feature("Проверки страницы 'Корзина'")
    @Test(testName = "Добавление в корзину два товара", description = "Добавление в корзину два товара")
    public void addTwoItemsToCart(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.scrollToBlockMostViewed();
        stepsMainPage.shouldBeVisibleForTitleMostViewed();
        stepsMainPage.checkThatTitleMostViewedIsDisplayed();
        stepsMainPage.clickTwoItems();
        stepsMainPage.clickOnButtonBasket();
        stepsBasketPage.checkThatUrlBasketCorrect();
        stepsBasketPage.checkComparisonNameInMainPageAndCart();
        stepsBasketPage.comparisonSumPriceInCardAndOrder();
        closeWebDriver();

    }
    @AfterMethod(description = "закрытие браузера")
    public void close(){
        closeWebDriver();
    }
}

