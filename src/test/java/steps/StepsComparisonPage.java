package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ComparisonPage;
import pages.HeaderPage;

public class StepsComparisonPage {

    private HeaderPage header = Selenide.page(new HeaderPage());
    private ComparisonPage comparisonPage = Selenide.page(new ComparisonPage());

    //Проверка отображения заголовка "Сравнение товаров"
    //Проверка отображения верного текста
    @Step("Проверка отображения заголовка 'Сравнение товаров'")
    public void checkThatTitleComparisonPageIsDisplayed(){
        boolean actualCondition = header.checkForDisplay(comparisonPage.getTitleComparisonPage());
        Assert.assertTrue(actualCondition,"Заголовок 'Сравнение товаров' не отображается");
    }
    //Проверка совпадения имени добавленных товаров в сравнение с товарами из листинга
    //Тут же происходит проверка количества добавленных товаров
    //Из за бага сайта иногда происходит некорректное отображение товаров на странице сравнения
    @Step("Проверка совпадения имени добавленных товаров в сравнение с товарами из листинга " +
            "Проверка количества добавленных товаров")
    public void checkThatNamesSameInComparisonAndProductPage(){
        comparisonPage.addElementsComparisonPage();
        Assert.assertTrue(comparisonPage.comparisonNameInProductAndComparisonPage(), "Имена/количество добавленных елементов не совпадают на странице сравнения с товарами из листинга");
    }

}
