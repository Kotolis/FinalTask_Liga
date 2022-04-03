package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.StepsComparisonPage;
import steps.StepsMainPage;
import steps.StepsProductPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestComparisonPage {
    private StepsMainPage stepsMainPage = new StepsMainPage();
    private StepsComparisonPage stepsComparisonPage = new StepsComparisonPage();
    private StepsProductPage stepsProductPage = new StepsProductPage();

    @Epic("Тесты для проверки сайта mvideo")
    @Feature("Проверки страницы 'Сравнение'")
    @Test(testName = "Проверка добавления товаров в список сравнения",
            description = "Проверка добавления товаров в список сравнения")
    public void checkAdditionsToComparisonList(){
        Configuration.pageLoadTimeout = 200000;
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://www.mvideo.ru/");
        stepsMainPage.checkThatInputLineIsDisplayed();
        stepsMainPage.checkThatValueEnterCorrect();
        stepsMainPage.clickOnButtonSearch();
        stepsProductPage.checkThatPageWithAppleOpen();
        stepsProductPage.addComparisonElementsInList();
        stepsProductPage.addThreeItemForComparison();
        stepsMainPage.clickOnButtonComparisonInHeader();
        stepsComparisonPage.checkThatTitleComparisonPageIsDisplayed();
        stepsComparisonPage.checkThatNamesSameInComparisonAndProductPage();
        closeWebDriver();
    }

    @AfterMethod(description = "закрытие браузера")
    public void close(){
        closeWebDriver();
    }
}
