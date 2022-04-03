package steps;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import pages.FavoritesPage;
import pages.HeaderPage;

public class StepsFavoritesPage {

    private HeaderPage header = Selenide.page(new HeaderPage());
    private FavoritesPage favoritesPage = Selenide.page(new FavoritesPage());

    //Проверка отображения заголовка "Избранное"
    //Проверка отображения верного текста
    public void checkThatTitleFavoritesPageIsDisplayed(){
        boolean actualCondition = header.checkForDisplay(favoritesPage.getTitleFavoritesPage());
        Assert.assertTrue(actualCondition);
    }

    //Проверка совпадения имени добавленных товаров в избранное с товарами из листинга
    //Тут же происходит проверка количества добавленных товаров
    //Из за бага сайта иногда происходит некорректное отображение товаров на странице сравнения
    public void checkThatNamesSameInFavoritesAndProductPage(){
        favoritesPage.scrollPageFavorites();
        favoritesPage.addElementsFavoritesPage();
        Assert.assertTrue(favoritesPage.comparisonNameInProductAndFavoritesPage());
    }
}
