package steps;

import com.codeborne.selenide.Condition;
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

    public void checkThatPageWithAppleOpen() {
        if (productPage.getPageArea().isDisplayed()) {
            Assert.assertEquals( WebDriverRunner.url(), "https://www.mvideo.ru/product-list-page?q=apple&category=smartfony-205");

        }
    }

    public void checkThatAppleNamePresent(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProducts();
        Assert.assertTrue(productPage.checkAppleName());
    }


    public void checkThatFilterSortIsDisplayed(){
        productPage.getFilterSort().scrollIntoView("{block: \"center\"}");
        boolean actualCondition = header.checkForDisplay(productPage.getFilterSort());
        Assert.assertTrue(actualCondition);
    }

    public void clickButtonFilterSort(){
        productPage.getFilterSort().scrollIntoView("{block: \"center\"}").shouldBe(Condition.visible).click();
        boolean actualCondition = header.checkForDisplay(productPage.getContainerFiltersSort());
        Assert.assertTrue(actualCondition);
    }

    public void clickFilterFirstMoreExpensive(){
        productPage.getFilterFirstMoreExpensive().scrollIntoView("{block: \"center\"}").shouldBe(Condition.visible).click();
    }

    public void checkThatPageWithFilterOpen() {
        productPage.nameProductToCheckPageLoad();
        Assert.assertEquals( WebDriverRunner.url(), "https://www.mvideo.ru/product-list-page?q=apple&category=smartfony-205&sort=price_desc");
    }


    public void comparisonPriceDescending(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProducts();
        Assert.assertTrue(productPage.priceComparison());
    }

    public void addComparisonElementsInList(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProductsComparison();
    }


    public void addThreeItemForComparison(){
        workArea.clickFewProducts(1);
        header.getNumberOnComparison( "1");
        workArea.clickFewProducts(2);
        header.getNumberOnComparison("2");
        workArea.clickFewProducts(3);
        header.getNumberOnComparison("3");

    }

    public void addFavoritesElementsInList(){
        productPage.scrollPageProduct();
        productPage.addPageAreaProductsFavorites();
    }

    public void addThreeItemForFavorites(){
        workArea.clickFewProducts(1);
        header.getNumberOnFavorites( "1");
        workArea.clickFewProducts(2);
        header.getNumberOnFavorites("2");
        workArea.clickFewProducts(3);
        header.getNumberOnFavorites("3");

    }

}
