package steps;

import com.codeborne.selenide.Condition;
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

    public void closeAlert(){
        if(comparisonPage.getCloseAlert().isDisplayed()){
            comparisonPage.getCloseAlert().shouldBe(Condition.visible).click();
        }
    }

    public void checkThatNamesSameInComparisonAndProductPage(){
        Assert.assertTrue(comparisonPage.comparisonNameInProductAndComparisonPage());
    }
}
