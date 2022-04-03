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


    //Проверка, что открылась страница корзины
    public void checkThatUrlBasketCorrect(){
        Selenide.sleep(3000);
        Assert.assertEquals(WebDriverRunner.url(),"https://www.mvideo.ru/cart");
    }

    //Проверка отображения заголовка "Моя корзина"
    //Проверка отображения верного текста
    public void checkThatTitleBasketIsDisplayed(){
        basket.getTitleBasket().shouldBe(Condition.visible);
        boolean actualCondition = header.checkForDisplay(basket.getTitleBasket());
        Assert.assertTrue(actualCondition);
    }

    //Проверка отображения имени товара в корзине
    public void checkThatProductInCartIsDisplayed(){
        boolean actualCondition = header.checkForDisplay(basket.getNameProduct());
        Assert.assertTrue(actualCondition);
    }

    //Проверка отображения кнопки "Перейти к оформлению"
    //Проверка отображения верного текста
    public void checkThatOrderingButtonIsDisplayed(){
        boolean actualCondition = header.checkForDisplay(basket.getOrderingButton());
        Assert.assertTrue(actualCondition);
    }

    //Проверка отображения текста "В корзине 1 товар"
    public void checkCorrectAmountProductsInBasket(){
        String expectedText = "В корзине 1 товар";
        String actualText = basket.getTextAmountProducts();
        Assert.assertEquals(expectedText,actualText);
    }

    //Проверка совпадения цены в карточке добавленного товара и в блоке оформления товара
    public void checkThatPriceInOrderAndCardSame(){
        Assert.assertEquals(basket.getCardPrice(),basket.getOrderPrice());
    }

    //Проверка совпадения имени на главной странице и в корзине
    public void checkComparisonNameInMainPageAndCart(){
        Assert.assertTrue(basket.comparisonNameInMainPageAndCart());
    }


    // Проверка совпадения суммы всей корзины с суммой цен добавленных товаров
    public void comparisonSumPriceInCardAndOrder(){
        basket.addElementsCart();
        Assert.assertTrue(basket.comparisonPriceInCart());
    }




}
