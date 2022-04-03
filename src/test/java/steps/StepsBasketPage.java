package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.BasketPage;
import pages.HeaderPage;
import pages.WorkAreaPage;

public class StepsBasketPage {
    private HeaderPage header = Selenide.page(new HeaderPage());
    private BasketPage basket = Selenide.page(new BasketPage());
    private WorkAreaPage workAreaPage = Selenide.page(new WorkAreaPage());


    //Проверка того,что открылась страница корзины
    @Step("Проверка того,что открылась страница корзины")
    public void checkThatUrlBasketCorrect(){
        Selenide.sleep(3000);
        Assert.assertEquals(WebDriverRunner.url(),"https://www.mvideo.ru/cart", "Страница корзины не открылась");
    }

    //Проверка отображения заголовка "Моя корзина"
    //Проверка отображения верного текста
    @Step("Проверка отображения заголовка 'Моя корзина'")
    public void checkThatTitleBasketIsDisplayed(){
        basket.getTitleBasket().shouldBe(Condition.visible);
        boolean actualCondition = header.checkForDisplay(basket.getTitleBasket());
        Assert.assertTrue(actualCondition, "Заголовок 'Моя корзина' не отображается");
    }

    //Проверка отображения имени товара в корзине
    @Step("Проверка отображения имени товара в корзине")
    public void checkThatProductInCartIsDisplayed(){
        boolean actualCondition = header.checkForDisplay(basket.getNameProduct());
        Assert.assertTrue(actualCondition, "Имя товара не отображается");
    }

    //Проверка отображения кнопки "Перейти к оформлению"
    //Проверка отображения верного текста
    @Step("Проверка отображения кнопки 'Перейти к оформлению'")
    public void checkThatOrderingButtonIsDisplayed(){
        boolean actualCondition = header.checkForDisplay(basket.getOrderingButton());
        Assert.assertTrue(actualCondition, "Кнопка 'Перейти к оформлению' не отображается");
    }

    //Проверка отображения текста "В корзине 1 товар"
    @Step("Проверка отображения текста 'В корзине 1 товар'")
    public void checkCorrectAmountProductsInBasket(){
        String expectedText = "В корзине 1 товар";
        String actualText = basket.getTextAmountProducts();
        Assert.assertEquals(expectedText,actualText, "Не верное отображение товара в корзине");
    }

    //Проверка совпадения цены в карточке добавленного товара и в блоке оформления товара
    @Step("Проверка совпадения цены в карточке добавленного товара и в блоке оформления товара")
    public void checkThatPriceInOrderAndCardSame(){
        Assert.assertEquals(basket.getCardPrice(),basket.getOrderPrice(), "Цены в карточке товара и в блоке оформления не совпадают");
    }

    //Проверка совпадения имени на главной странице и в корзине
    @Step("Проверка совпадения имени на главной странице и в корзине")
    public void checkComparisonNameInMainPageAndCart(){
        Assert.assertTrue(basket.comparisonNameInMainPageAndCart(), "Имя на главной странице и в корзине не совмадает");
    }


    // Проверка совпадения суммы всей корзины с суммой цен добавленных товаров
    @Step("Проверка совпадения суммы всей корзины с суммой цен добавленных товаров")
    public void comparisonSumPriceInCardAndOrder(){
        basket.addElementsCart();
        Assert.assertTrue(basket.comparisonPriceInCart(), "Сумма всей корзины не совпадает с суммой цен добавленных товаров");
    }




}
