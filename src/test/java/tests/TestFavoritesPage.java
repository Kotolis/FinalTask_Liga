package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.StepsComparisonPage;
import steps.StepsFavoritesPage;
import steps.StepsMainPage;
import steps.StepsProductPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestFavoritesPage {

    private StepsMainPage stepsMainPage = new StepsMainPage();
    private StepsComparisonPage stepsComparisonPage = new StepsComparisonPage();
    private StepsProductPage stepsProductPage = new StepsProductPage();
    private StepsFavoritesPage stepsFavoritesPage = new StepsFavoritesPage();

    @Epic("Тесты для проверки сайта mvideo")
    @Feature("Проверки страницы 'Избранное'")
    @Test(testName = "Проверка добавления товаров в список избранного",
            description = "Проверка добавления товаров в список избранного")
    public void checkAdditionsToFavoritesList(){
        Configuration.pageLoadTimeout = 200000;
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.checkThatInputLineIsDisplayed();
        stepsMainPage.checkThatValueEnterCorrect();
        stepsMainPage.clickOnButtonSearch();
        stepsProductPage.checkThatPageWithAppleOpen();
        stepsProductPage.addFavoritesElementsInList();
        stepsProductPage.addThreeItemForFavorites();
        stepsMainPage.clickOnButtonFavoritesInHeader();
        stepsFavoritesPage.checkThatTitleFavoritesPageIsDisplayed();
        stepsFavoritesPage.checkThatNamesSameInFavoritesAndProductPage();
        closeWebDriver();
    }

    @AfterMethod(description = "закрытие браузера")
    public void close(){
        closeWebDriver();
    }
}
