package steps;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import pages.FavoritesPage;
import pages.HeaderPage;

public class StepsFavoritesPage {

    private HeaderPage header = Selenide.page(new HeaderPage());
    private FavoritesPage favoritesPage = Selenide.page(new FavoritesPage());


    public void checkThatTitleFavoritesPageIsDisplayed(){
        boolean actualCondition = header.checkForDisplay(favoritesPage.getTitleFavoritesPage());
        Assert.assertTrue(actualCondition);
    }

    public void checkThatNamesSameInFavoritesAndProductPage(){
        Assert.assertTrue(favoritesPage.comparisonNameInProductAndFavoritesPage());
    }
}
