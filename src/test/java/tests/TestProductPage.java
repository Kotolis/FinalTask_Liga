package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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

    @Epic("Тесты для проверки сайта mvideo")
    @Feature("Проверки страницы листинга")
    @Test(testName = "Поиск товаров", description = "Поиск товаров")
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

    @Epic("Тесты для проверки сайта mvideo")
    @Feature("Проверки страницы листинга")
    @Test(testName = "Сорторовка товаров в листинге", description = "Сорторовка товаров в листинге")
    public void sortingItemsInTheListing(){
        Configuration.pageLoadTimeout = 200000;
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.checkThatInputLineIsDisplayed();
        stepsMainPage.checkThatValueEnterCorrect();
        stepsMainPage.clickOnButtonSearch();
        stepsProductPage.checkThatPageWithAppleOpen();
        stepsProductPage.checkThatAppleNamePresent();
        stepsProductPage.checkThatFilterSortIsDisplayed();
        stepsProductPage.clickButtonFilterSort();
        stepsProductPage.clickFilterFirstMoreExpensive();
        stepsProductPage.checkThatPageWithFilterOpen();
        stepsProductPage.checkThatAppleNamePresent();
        stepsProductPage.comparisonPriceDescending();
        closeWebDriver();
    }

    @AfterMethod(description = "закрытие браузера")
    public void close(){
        closeWebDriver();
    }
}
