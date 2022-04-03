package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.HeaderPage;
import pages.ProductPage;
import pages.WorkAreaPage;


public class StepsProductPage {

    private HeaderPage header = Selenide.page(new HeaderPage());
    private WorkAreaPage workArea = Selenide.page(new WorkAreaPage());
    private ProductPage productPage = Selenide.page(new ProductPage());

    //Проверка того, что открылась правильная страница
    @Step("Проверка того, что открылась правильная страница")
    public void checkThatPageWithAppleOpen() {
        productPage.nameProductToCheckPageLoad();
        if (productPage.getPageArea().isDisplayed()) {
            Assert.assertEquals( WebDriverRunner.url(), "https://www.mvideo.ru/product-list-page?q=apple&category=smartfony-205", "Открылась не правильная страница");
        }
    }

    //Проверка присутствия "apple" во всех именах продуктов на странице
    //Прокрутка листинга при каждом сборе в значений в список добавлена для независимости шагов
    @Step("Проверка присутствия 'apple' во всех именах продуктов на странице")
    public void checkThatAppleNamePresent(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProducts();
        Assert.assertTrue(productPage.checkAppleName(), "'apple' отсутствует в имени");
    }

    //Проверка отображения выпадающего списка сортировки со значением "Сначала популярные"
    //Проверка отображения верного текста
    @Step("Проверка отображения выпадающего списка сортировки со значением 'Сначала популярные'")
    public void checkThatFilterSortIsDisplayed(){
        productPage.getFilterSort().scrollIntoView("{block: \"center\"}");
        boolean actualCondition = header.checkForDisplay(productPage.getFilterSort());
        Assert.assertTrue(actualCondition, "Выпадающий список не отображается");
    }

    //Нажатие на выпадающий список сортировки со значением  "Сначала популярные"
    //Проверка отображения списка сортировки
    @Step("Нажатие на выпадающий список сортировки со значением  'Сначала популярные'")
    public void clickButtonFilterSort(){
        header.click(productPage.getFilterSort());
        boolean actualCondition = header.checkForDisplay(productPage.getContainerFiltersSort());
        Assert.assertTrue(actualCondition, "Список сортировки не отображается");
    }

    //Нажатие на значение "Сначала дороже" из списка
    //Проверка отображения верного текста
    @Step("Нажатие на значение 'Сначала дороже' из списка")
    public void clickFilterFirstMoreExpensive(){
        header.click(productPage.getFilterFirstMoreExpensive());
    }

    //Проверка, что страница с отфильтрованными товарами открыта
    @Step("Проверка, что страница с отфильтрованными товарами открыта")
    public void checkThatPageWithFilterOpen() {
        productPage.nameProductToCheckPageLoad();
        Assert.assertEquals( WebDriverRunner.url(), "https://www.mvideo.ru/product-list-page?q=apple&category=smartfony-205&sort=price_desc", "Страница с отфильтрованными товарами не открыта");
    }


    //Проверка, что цена на странице расположена по убыванию
    //Прокрутка листинга при каждом сборе в значений в список добавлена для независимости шагов
    @Step("Проверка, что цена на странице расположена по убыванию")
    public void comparisonPriceDescending(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProducts();
        Assert.assertTrue(productPage.priceComparison(), "Цена на странице расположена не по убыванию");
    }

    //Добавление товаров на странице в список, для страницы сравнения
    //Прокрутка листинга при каждом сборе в значений в список добавлена для независимости шагов
    @Step("Добавление товаров на странице в список, для страницы сравнения")
    public void addComparisonElementsInList(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProductsComparison();
    }


    //Добавление 3 товаров в сравнение
    //Проверка отображения количества добавленных элементов в сравнение
    @Step("Добавление 3 товаров в сравнение " +
            "Проверка отображения количества добавленных элементов в сравнение")
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
    @Step("Добавление товаров на странице в список, для страницы избранное")
    public void addFavoritesElementsInList(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProductsFavorites();
    }

    //Добавление 3 товаров в избранное
    //Проверка отображения количества добавленных элементов в сравнение
    @Step("Добавление 3 товаров в избранное " +
            "Проверка отображения количества добавленных элементов в сравнение")
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
