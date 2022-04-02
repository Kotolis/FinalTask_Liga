package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import pages.BasketPage;
import pages.HeaderPage;
import pages.WorkAreaPage;

public class StepsBasketPage {
    private HeaderPage header = Selenide.page(new HeaderPage());
    private BasketPage basket = Selenide.page(new BasketPage());
    private WorkAreaPage workAreaPage = Selenide.page(new WorkAreaPage());


    public void checkThatUrlBasketCorrect(){
        Selenide.sleep(3000);
        Assert.assertEquals(WebDriverRunner.url(),"https://www.mvideo.ru/cart");
    }

    public void checkThatTitleBasketIsDisplayed(){
        basket.getTitleBasket().shouldBe(Condition.visible);
        boolean actualCondition = header.checkForDisplay(basket.getTitleBasket());
        Assert.assertTrue(actualCondition);
    }


    public void checkThatOrderingButtonIsDisplayed(){
        boolean actualCondition = header.checkForDisplay(basket.getOrderingButton());
        Assert.assertTrue(actualCondition);
    }

    public void checkCorrectAmountProductsInBasket(){
        String expectedText = "В корзине 1 товар";
        String actualText = basket.getTextAmountProducts();
        Assert.assertEquals(expectedText,actualText);
    }

    public void checkThatPriceInOrderAndCardSame(){
        Assert.assertEquals(basket.getCardPrice(),basket.getOrderPrice());
    }

    public void checkComparisonNameInMainPageAndCart(){
        Assert.assertTrue(basket.comparisonNameInMainPageAndCart());
    }

    public void comparisonPriceInCardAndOrder(){
        basket.addElementsCart();
        Assert.assertTrue(basket.comparisonPriceInCart());
    }




}
