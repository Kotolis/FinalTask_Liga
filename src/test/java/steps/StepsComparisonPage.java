package steps;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import pages.ComparisonPage;
import pages.HeaderPage;

public class StepsComparisonPage {

    private HeaderPage header = Selenide.page(new HeaderPage());
    private ComparisonPage comparisonPage = Selenide.page(new ComparisonPage());

    public void checkThatTitleComparisonPageIsDisplayed(){
        boolean actualCondition = header.checkForDisplay(comparisonPage.getTitleComparisonPage());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatNamesSameInComparisonAndProductPage(){
        comparisonPage.addElementsComparisonPage();
        System.out.println("Все добавил начинаю сравнивать");
        Assert.assertTrue(comparisonPage.comparisonNameInProductAndComparisonPage());
    }
}
