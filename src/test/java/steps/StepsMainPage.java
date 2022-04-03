package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.HeaderPage;
import pages.WorkAreaPage;

public class StepsMainPage {

    private HeaderPage header = Selenide.page(new HeaderPage());
    private WorkAreaPage workArea = Selenide.page(new WorkAreaPage());


    //Проверка отображения кнопки "Статус заказа"
    //Проверка отображения верного текста
    @Step("Проверка отображения кнопки 'Статус заказа'")
    public void checkThatButtonStatusOrderIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getStatusOrder());
        Assert.assertTrue(actualCondition, "Кнопка 'Статус заказа' не отображается");
    }
    //Проверка активности кнопки "Статус заказа"
    //Проверка отображения верного текста
    @Step("Проверка активности кнопки 'Статус заказа'")
    public void checkThatButtonStatusOrderIsEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getStatusOrder());
        Assert.assertTrue(actualCondition, "Кнопка 'Статус заказа' не активна");
    }

    //Проверка отображения кнопки "Войти"
    //Проверка отображения верного текста
    @Step("Проверка отображения кнопки 'Войти'")
    public void checkThatButtonRegistrationIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getRegistration());
        Assert.assertTrue(actualCondition, "Кнопка 'Войти' не отображается");
    }

    //Проверка активности кнопки "Войти"
    //Проверка отображения верного текста
    @Step("Проверка активности кнопки 'Войти'")
    public void checkThatButtonRegistrationIsEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getRegistration());
        Assert.assertTrue(actualCondition, "Кнопка 'Войти' не активна");
    }

    //Проверка отображения кнопки "Сравнение"
    //Проверка отображения верного текста
    @Step("Проверка отображения кнопки 'Сравнение'")
    public void checkThatButtonComparisonIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getComparison());
        Assert.assertTrue(actualCondition, "Кнопка 'Сравнение' не отображается");
    }

    //Проверка того, что кнопка "Сравнение" не активна
    //Проверка отображения верного текста
    @Step("Проверка того, что кнопка 'Сравнение' не активна")
    public void checkThatButtonComparisonIsNotEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getComparison());
        Assert.assertFalse(actualCondition, "Кнопка 'Сравнение' активна");
    }

    //Проверка отображения кнопки "Избранное"
    //Проверка отображения верного текста
    @Step("Проверка отображения кнопки 'Избранное'")
    public void checkThatButtonFavoritesIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getFavorites());
        Assert.assertTrue(actualCondition, "Кнопка 'Избранное' не отображается");
    }

    //Проверка того, что кнопка "Избранное" не активна
    //Проверка отображения верного текста
    @Step("Проверка того, что кнопка 'Избранное' не активна")
    public void checkThatButtonFavoritesIsNotEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getFavorites());
        Assert.assertFalse(actualCondition, "Кнопка 'Избранное' активна");

    }

    //Проверка отображения кнопки "Корзина"
    //Проверка отображения верного текста
    @Step("Проверка отображения кнопки 'Корзина'")
    public void checkThatButtonAddToCartIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getAddToCart());
        Assert.assertTrue(actualCondition, "Кнопка 'Корзина' не отображается");
    }

    //Проверка того, что кнопка "Корзина" не активна
    //Проверка отображения верного текста
    @Step("Проверка того, что кнопка 'Корзина' не активна")
    public void checkThatButtonAddToCartIsNotEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getAddToCart());
        Assert.assertFalse(actualCondition, "Кнопка 'Корзина' активна");
    }

    //Проверка отображения блока "Товары дня"
    //Проверка отображения верного текста
    @Step("Проверка отображения блока 'Товары дня'")
    public void checkThatBlockWithProductDayIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(workArea.blockWithProductDay());
        Assert.assertTrue(actualCondition, "Блок 'Товары дня' не отображается");

    }

    //Нажатие на кнопку "В корзину" в блоке продукта дня
    //Тут же проверка на отображение кнопки "В корзину" в блоке продукта дня
    @Step("Нажатие на кнопку 'В корзину' в блоке продукта дня")
    public void clickOnButtonAddToCartProductDay() {
        workArea.addToCartProductDayDisplayed();

    }

    //Проверка отображения количества товаров, добавленных в корзину
    @Step("Проверка отображения количества товаров, добавленных в корзину")
    public void checkNumberOnTheCartDisplayed() {
        header.getNumberOnTheCart("1");
    }


    //Проверка активности кнопки "Корзина"
    //Проверка отображения верного текста
    @Step("Проверка активности кнопки 'Корзина'")
    public void checkThatButtonAddToCartProductDayIsEnabled() {
        boolean actualCondition = header.checkForEnabled(header.getAddToCart());
        Assert.assertTrue(actualCondition, "Кнопка 'Корзина' не активна");
    }

    //Нажатие на кнопку "Корзина"
    //Проверка отображения верного текста
    @Step("Нажатие на кнопку 'Корзина'")
    public void clickOnButtonBasket() {
        header.getAddToCart().shouldBe(Condition.visible);
        header.click(header.getAddToCart());
    }

    //Прокрутка до блока "Самые просматриваемые"
    @Step("Прокрутка до блока 'Самые просматриваемые'")
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
    @Step("Проверка видимости заголовка 'Самые просматриваемые'")
    public void shouldBeVisibleForTitleMostViewed() {
        workArea.titleMostViewedVisible();
    }

    //Проверка отображения заголовка "Самые просматриваемые"
    //Проверка отображения верного текста
    @Step("Проверка отображения заголовка 'Самые просматриваемые'")
    public void checkThatTitleMostViewedIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(workArea.getTitleMostViewed());
        Assert.assertTrue(actualCondition, "Заголовок 'Самые просматриваемые' не отображается");
    }


    //Нажатие на 2 первых товара в блоке "Самые просматриваемые"
    //Проверка отображения количества товаров, добавленных в корзину
    @Step("Нажатие на 2 первых товара в блоке 'Самые просматриваемые' " +
            "Проверка отображения количества товаров, добавленных в корзину")
    public void clickTwoItems() {
        workArea.addMultipleProducts();
        workArea.clickFewProducts(1);
        header.getNumberOnTheCart("1");
        workArea.clickFewProducts(2);
        header.getNumberOnTheCart("2");

    }

    //Проверка отображения строки поиска
    @Step("Проверка отображения строки поиска")
    public void checkThatInputLineIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getInputLine());
        Assert.assertTrue(actualCondition, "Строка поиска не отображается");
    }

    //Проверка правильности ввода значения
    @Step("Проверка правильности ввода значения")
    public void checkThatValueEnterCorrect() {
        header.enterValue("apple");
        Assert.assertEquals(header.getEnterValue(), "apple", "Значение введено не правильно");
    }

    //Нажатие на кнопку поиска
    @Step("Нажатие на кнопку поиска")
    public void clickOnButtonSearch() {
        header.click(header.getButtonSearch());
    }

    //Нажатие на кнопку "Войти"
    //Проверка отображения верного текста
    @Step("Нажатие на кнопку 'Войти'")
    public void clickOnButtonRegistration() {
        header.click(header.getRegistration());
    }

    //Проверка отображения модального окна "Вход или регистрация"
    @Step("Проверка отображения модального окна 'Вход или регистрация'")
    public void checkThatFormRegistrationIsDisplayed() {
        header.getFormRegistration().scrollIntoView("{block: \"center\"}").shouldBe(Condition.visible);
        boolean actualCondition = header.checkForDisplay(header.getFormRegistration());
        Assert.assertTrue(actualCondition, "Модальное окно 'Вход или регистрация' не отображается");
    }

    //Проверка отобраажения заголовка "Вход или регистрация"
    //Проверка отображения верного текста
    @Step("Проверка отобраажения заголовка 'Вход или регистрация'")
    public void checkThatTitleLoginOrRegistrationIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getTitleLoginOrRegistration());
        Assert.assertTrue(actualCondition, "Заголовок 'Вход или регистрация' не отображается");
    }

    //Проверка отображения поля для ввода текста с плейсхолдером "Телефон"
    //Проверка отображения верного текста
    @Step("Проверка отображения поля для ввода текста с плейсхолдером 'Телефон'")
    public void checkThatPhoneInputFieldIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getPhoneInputField());
        Assert.assertTrue(actualCondition, "Поле для ввода не отображается");
    }

    //Проверка того, что кнопка "Продолжить" не активна
    //Проверка отображения верного текста
    @Step("Проверка того, что кнопка 'Продолжить' не активна")
    public void checkThatButtonContinueIsNotEnabled() {
        boolean actualCondition = header.checkForDisabled();
        Assert.assertFalse(actualCondition, "Кнопка 'Продолжить' активна");
    }

    //Проверка отображения ссылки "Для юридических лиц"
    //Проверка отображения верного текста
    @Step("Проверка отображения ссылки 'Для юридических лиц'")
    public void checkThatLinkLegalEntitiesIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getLinkLegalEntities());
        Assert.assertTrue(actualCondition, "Ссылка 'Для юридических лиц' не отображается");
    }

    //Нажатие на кнопку "Сравнение"
    //Проверка отображения верного текста
    @Step("Нажатие на кнопку 'Сравнение'")
    public void clickOnButtonComparisonInHeader(){
        header.click(header.getComparison());
    }

    //Нажатие на кнопку "Избранное"
    //Проверка отображения верного текста
    @Step("Нажатие на кнопку 'Избранное'")
    public void clickOnButtonFavoritesInHeader(){
        header.click(header.getFavorites());
    }

    //Нажатие на кнопку текущего города
    @Step("Нажатие на кнопку текущего города")
    public void clickOnLocationButton(){
        header.click(header.getLocationButton());
    }

    //Проверка того, что открыто модальное окно с заголовком "Выберите город"
    //Проверка отображения верного текста заголовка
    @Step("Проверка того, что открыто модальное окно с заголовком 'Выберите город'")
    public void checkThatWindowSelectCityIsDisplayed() {
        boolean actualCondition = header.checkForDisplay(header.getWindowSelectCity());
        Assert.assertTrue(actualCondition, "Модальное окно 'Выберите город' не открыто");
    }

    //Нажатие на нужный город
    //Закрытие модального окна
    @Step("Нажатие на нужный город " +
            "Закрытие модального окна")
    public void selectDesiredCity(String city){
        header.findCity("Краснодар");
        header.closeForModalWindow();
    }


    //Отображение кнопки для проверка прогрузки страницы
    @Step("Отображение кнопки для проверка прогрузки страницы")
    public void displayButtonToCheckPageLoading(){
        workArea.buttonDisplayForDownloadVerification();
    }

    //Проверка отображения на странице выбранного города
    @Step("Проверка отображения на странице выбранного города")
    public void checkDisplayedLocator(String text){
        Assert.assertTrue(header.displayedLocator("Краснодар"), "Выбранный город не отображается на странице");
    }

}






