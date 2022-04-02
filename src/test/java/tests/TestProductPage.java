package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.StepsBasketPage;
import steps.StepsMainPage;
import steps.StepsProductPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestProductPage {

    private StepsBasketPage stepsBasketPage = new StepsBasketPage();
    private StepsMainPage stepsMainPage = new StepsMainPage();
    private StepsProductPage stepsProductPage = new StepsProductPage();

    @Test
    public void productSearch() {
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.checkThatInputLineIsDisplayed();
        stepsMainPage.checkThatValueEnterCorrect();
        stepsMainPage.clickOnButtonSearch();
        stepsProductPage.checkThatPageWithAppleOpen();
        stepsProductPage.checkThatAppleNamePresent();
        closeWebDriver();

    }

    @Test
    public void sortingItemsInTheListing(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.checkThatInputLineIsDisplayed();
        stepsMainPage.checkThatValueEnterCorrect();
        stepsMainPage.clickOnButtonSearch();
        stepsProductPage.checkThatPageWithAppleOpen();
        stepsProductPage.checkThatFilterSortIsDisplayed();
        stepsProductPage.clickButtonFilterSort();
        stepsProductPage.clickFilterFirstMoreExpensive();
        stepsProductPage.checkThatPageWithFilterOpen();
        stepsProductPage.checkThatAppleNamePresent();
        stepsProductPage.comparisonPriceDescending();
        closeWebDriver();
    }

    @AfterMethod
    public void close(){
        closeWebDriver();
    }
}
