package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import pages.BasketPage;
import pages.HeaderPage;
import pages.WorkAreaPage;

public class StepsMainPage {

    private HeaderPage header = Selenide.page(new HeaderPage());
    private WorkAreaPage workArea = Selenide.page(new WorkAreaPage());


    //Проверка отображения кнопки "Статус заказа"
    //Проверка отображения верного текста
    public void checkThatButtonStatusOrderIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getStatusOrder());
        Assert.assertTrue(actualCondition);
    }
    //Проверка активности кнопки "Статус заказа"
    //Проверка отображения верного текста
    public void checkThatButtonStatusOrderIsEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getStatusOrder());
        Assert.assertTrue(actualCondition);
    }

    //Проверка отображения кнопки "Войти"
    //Проверка отображения верного текста
    public void checkThatButtonRegistrationIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getRegistration());
        Assert.assertTrue(actualCondition);
    }

    //Проверка активности кнопки "Войти"
    //Проверка отображения верного текста
    public void checkThatButtonRegistrationIsEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getRegistration());
        Assert.assertTrue(actualCondition);
    }

    //Проверка отображения кнопки "Сравнение"
    //Проверка отображения верного текста
    public void checkThatButtonComparisonIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getComparison());
        Assert.assertTrue(actualCondition);
    }

    //Проверка того, что кнопка "Сравнение" не активна
    //Проверка отображения верного текста
    public void checkThatButtonComparisonIsNotEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getComparison());
        Assert.assertFalse(actualCondition);
    }

    //Проверка отображения кнопки "Избранное"
    //Проверка отображения верного текста
    public void checkThatButtonFavoritesIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getFavorites());
        Assert.assertTrue(actualCondition);
    }

    //Проверка того, что кнопка "Избранное" не активна
    //Проверка отображения верного текста
    public void checkThatButtonFavoritesIsNotEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getFavorites());
        Assert.assertFalse(actualCondition);

    }

    //Проверка отображения кнопки "Корзина"
    //Проверка отображения верного текста
    public void checkThatButtonAddToCartIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getAddToCart());
        Assert.assertTrue(actualCondition);
    }

    //Проверка того, что кнопка "Корзина" не активна
    //Проверка отображения верного текста
    public void checkThatButtonAddToCartIsNotEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getAddToCart());
        Assert.assertFalse(actualCondition);
    }

    //Проверка отображения блока "Товары дня"
    //Проверка отображения верного текста
    public void checkThatBlockWithProductDayIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(workArea.blockWithProductDay());
        Assert.assertTrue(actualCondition);

    }

    //Нажатие на кнопку "В корзину" в блоке продукта дня
    //Тут же проверка на отображение кнопки "В корзину" в блоке продукта дня
    public void clickOnButtonAddToCartProductDay() {
        workArea.addToCartProductDayDisplayed();

    }

    //Проверка отображения количества товаров, добавленных в корзину
    public void checkNumberOnTheCartDisplayed() {
        header.getNumberOnTheCart("1");
    }


    //Проверка активности кнопки "Корзина"
    //Проверка отображения верного текста
    public void checkThatButtonAddToCartProductDayIsEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getAddToCart());
        Assert.assertTrue(actualCondition);
    }

    //Нажатие на кнопку "Корзина"
    //Проверка отображения верного текста
    public void clickOnButtonBasket() {
        header.getAddToCart().shouldBe(Condition.visible);
        header.click(header.getAddToCart());
    }

    //Прокрутка до блока "Самые просматриваемые"
    public void scrollToBlockMostViewed() {
        workArea.scrollToFirstBlockMostViewed();
        if (workArea.getBlockMostViewedWithText().isDisplayed()) {
            workArea.getBlockMostViewedWithText().shouldBe(Condition.visible);
        } else {
            workArea.getBlockMostViewed2().scrollIntoView("{block: \"center\"}").shouldBe(Condition.visible);
        }
    }

    //Проверка видимости заголовка "Самые просматриваемые"
    //Проверка отображения верного текста
    public void shouldBeVisibleForTitleMostViewed() {
        workArea.titleMostViewedVisible();
    }

    //Проверка отображения заголовка "Самые просматриваемые"
    //Проверка отображения верного текста
    public void checkThatTitleMostViewedIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(workArea.getTitleMostViewed());
        Assert.assertTrue(actualCondition);
    }


    //Нажатие на 2 первых товара в блоке "Самые просматриваемые"
    //Проверка отображения количества товаров, добавленных в корзину
    public void clickTwoItems() {
        workArea.addMultipleProducts();
        workArea.clickFewProducts(1);
        header.getNumberOnTheCart("1");
        workArea.clickFewProducts(2);
        header.getNumberOnTheCart("2");

    }

    //Проверка отображения строки поиска
    public void checkThatInputLineIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getInputLine());
        Assert.assertTrue(actualCondition);
    }

    //Проверка правильности ввода значения
    public void checkThatValueEnterCorrect() {
        header.enterValue("apple");
        Assert.assertEquals(header.getEnterValue(), "apple");
    }

    //Нажатие на кнопку поиска
    public void clickOnButtonSearch() {
        header.click(header.getButtonSearch());
    }

    //Нажатие на кнопку "Войти"
    //Проверка отображения верного текста
    public void clickOnButtonRegistration() {
        header.click(header.getRegistration());
    }

    //Проверка отображения модального окна "Вход или регистрация"
    public void checkThatFormRegistrationIsDisplayed() {
        header.getFormRegistration().scrollIntoView("{block: \"center\"}").shouldBe(Condition.visible);
        boolean actualCondition = header.checkForDisplay(header.getFormRegistration());
        Assert.assertTrue(actualCondition);
    }

    //Проверка отобраажения заголовка "Вход или регистрация"
    //Проверка отображения верного текста
    public void checkThatTitleLoginOrRegistrationIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getTitleLoginOrRegistration());
        Assert.assertTrue(actualCondition);
    }

    //Проверка отображения поля для ввода текста с плейсхолдером "Телефон"
    //Проверка отображения верного текста
    public void checkThatPhoneInputFieldIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getPhoneInputField());
        Assert.assertTrue(actualCondition);
    }

    //Проверка того, что кнопка "Продолжить" не активна
    //Проверка отображения верного текста
    public void checkThatButtonContinueIsNotEnabled() {
        boolean actualCondition = header.checkForDisabled();
        Assert.assertFalse(actualCondition);
    }

    //Проверка отображения ссылки "Для юридических лиц"
    //Проверка отображения верного текста
    public void checkThatLinkLegalEntitiesIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getLinkLegalEntities());
        Assert.assertTrue(actualCondition);
    }

    //Нажатие на кнопку "Сравнение"
    //Проверка отображения верного текста
    public void clickOnButtonComparisonInHeader(){
        header.click(header.getComparison());
    }

    //Нажатие на кнопку "Избранное"
    //Проверка отображения верного текста
    public void clickOnButtonFavoritesInHeader(){
        header.click(header.getFavorites());
    }

    //Нажатие на кнопку текущего города
    public void clickOnLocationButton(){
        header.click(header.getLocationButton());
    }

    //Проверка того, что открыто модальное окно с заголовком "Выберите город"
    //Проверка отображения верного текста заголовка
    public void checkThatWindowSelectCityIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getWindowSelectCity());
        Assert.assertTrue(actualCondition);
    }

    //Нажатие на нажный город
    //Закрытие модального окна
    public void selectDesiredCity(String city){
        header.findCity("Краснодар");
        header.closeForModalWindow();
    }


    //Отображение кнопки для проверка прогрузки страницы
    public void displayButtonToCheckPageLoading(){
        workArea.buttonDisplayForDownloadVerification();
    }

    //Проверка отображения на странице выбранного города
    public void checkDisplayedLocator(String text){
        Assert.assertTrue(header.displayedLocator("Краснодар"));
    }

}






