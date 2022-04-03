package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import pages.HeaderPage;
import pages.ProductPage;
import pages.WorkAreaPage;


public class StepsProductPage {

    private HeaderPage header = Selenide.page(new HeaderPage());
    private WorkAreaPage workArea = Selenide.page(new WorkAreaPage());
    private ProductPage productPage = Selenide.page(new ProductPage());

    //Проверка того, что открылась правильная страница
    public void checkThatPageWithAppleOpen() {
        productPage.nameProductToCheckPageLoad();
        if (productPage.getPageArea().isDisplayed()) {
            Assert.assertEquals( WebDriverRunner.url(), "https://www.mvideo.ru/product-list-page?q=apple&category=smartfony-205");
        }
    }

    //Проверка присутствия "apple" во всех именах продуктов на странице
    //Прокрутка листинга при каждом сборе в значений в список добавлена для независимости шагов
    public void checkThatAppleNamePresent(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProducts();
        Assert.assertTrue(productPage.checkAppleName());
    }

    //Проверка выпадающего списка сортировки со значением "Сначала популярные"
    //Проверка отображения верного текста
    public void checkThatFilterSortIsDisplayed(){
        productPage.getFilterSort().scrollIntoView("{block: \"center\"}");
        boolean actualCondition = header.checkForDisplay(productPage.getFilterSort());
        Assert.assertTrue(actualCondition);
    }

    //Нажатие на выпадающий список сортировки со значением  "Сначала популярные"
    //Проверка отображения списка сортировки
    public void clickButtonFilterSort(){
        header.click(productPage.getFilterSort());
        boolean actualCondition = header.checkForDisplay(productPage.getContainerFiltersSort());
        Assert.assertTrue(actualCondition);
    }

    //Нажатие на значение "Сначала дороже" из списка
    //Проверка отображения верного текста
    public void clickFilterFirstMoreExpensive(){
        header.click(productPage.getFilterFirstMoreExpensive());
    }

    //Проверка, что страница с отфильтрованными товарами открыта
    public void checkThatPageWithFilterOpen() {
        productPage.nameProductToCheckPageLoad();
        Assert.assertEquals( WebDriverRunner.url(), "https://www.mvideo.ru/product-list-page?q=apple&category=smartfony-205&sort=price_desc");
    }


    //Проверка, что цена на странице расположена по убыванию
    //Прокрутка листинга при каждом сборе в значений в список добавлена для независимости шагов
    public void comparisonPriceDescending(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProducts();
        Assert.assertTrue(productPage.priceComparison());
    }

    //Добавление товаров на странице в список, для страницы сравнения
    //Прокрутка листинга при каждом сборе в значений в список добавлена для независимости шагов
    public void addComparisonElementsInList(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProductsComparison();
    }


    //Добавление 3 товаров в сравнение
    //Проверка отображения количества добавленных элементов в сравнение
    public void addThreeItemForComparison(){
        productPage.clearComparisonList();
        workArea.clickFewProducts(1);
        header.getNumberOnComparison( "1");
        workArea.clickFewProducts(2);
        header.getNumberOnComparison("2");
        workArea.clickFewProducts(3);
        header.getNumberOnComparison("3");

    }

    //Добавление товаров на странице в список, для страницы избранное
    //Прокрутка листинга при каждом сборе в значений в список добавлена для независимости шагов
    public void addFavoritesElementsInList(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProductsFavorites();
    }

    //Добавление 3 товаров в избранное
    //Проверка отображения количества добавленных элементов в сравнение
    public void addThreeItemForFavorites(){
        productPage.clearComparisonList();
        workArea.clickFewProducts(1);
        header.getNumberOnFavorites( "1");
        workArea.clickFewProducts(2);
        header.getNumberOnFavorites("2");
        workArea.clickFewProducts(3);
        header.getNumberOnFavorites("3");

    }

}
