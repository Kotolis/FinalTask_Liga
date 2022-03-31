package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import steps.StepsBasketPage;
import steps.StepsMainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBasketPage {

   private StepsBasketPage stepsBasketPage = new StepsBasketPage();
   private StepsMainPage stepsMainPage = new StepsMainPage();

    @Test
    public void openingBasket(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.checkThatBlockWithProductDayIsDisplayed();
        stepsMainPage.clickOnButtonAddToCartProductDay();
        stepsMainPage.clickOnButtonBasket();
        stepsBasketPage.checkThatUrlBasketCorrect();
        stepsBasketPage.checkThatTitleBasketIsDisplayed();
        stepsBasketPage.checkThatOrderingButtonIsDisplayed();
        stepsBasketPage.checkCorrectAmountProductsInBasket();
        stepsBasketPage.checkThatPriceInOrderAndCardSame();
        closeWebDriver();
    }

    @Test
    public void addTwoItemsToCart(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.scrollToBlockMostViewed();
        stepsMainPage.shouldBeVisibleForTitleMostViewed();
        stepsMainPage.checkThatTitleMostViewedIsDisplayed();
        stepsMainPage.clickTwoItems();
        stepsMainPage.clickOnButtonBasket();
        stepsBasketPage.checkComparisonNameInMainPageAndCart();
        stepsBasketPage.comparisonPriceInCardAndOrder();
        closeWebDriver();

    }
}

