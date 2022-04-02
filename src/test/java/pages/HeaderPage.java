package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;


public class HeaderPage {
    private SelenideElement addStatusOrder;
    private SelenideElement addRegistration;
    private SelenideElement addComparison;
    private SelenideElement addFavorites;
    private SelenideElement addToCart;
    private SelenideElement addNumberOnTheCart;
    private SelenideElement inputLine;
    private SelenideElement buttonSearch;
    private SelenideElement formRegistration;
    private SelenideElement titleLoginOrRegistration;
    private SelenideElement phoneInputField;
    private SelenideElement buttonContinue;
    private SelenideElement linkLegalEntities;
    private SelenideElement amountsItemsInComparison;
    private SelenideElement amountsItemsInFavorites;
    private SelenideElement locationButton;
    private SelenideElement windowSelectCity;


    public HeaderPage(){

        addStatusOrder = Selenide.$x("//mvid-header-icon[.//p[@class = 'title' and text() = 'Статус заказа']]");

        addRegistration = Selenide.$x("//mvid-header-icon[.//p[@class = 'title' and text() = 'Войти']]");

        addComparison = Selenide.$x("//mvid-header-icon[.//p[@class = 'title' and text() = 'Сравнение']]");

        addFavorites = Selenide.$x("//mvid-header-icon[.//p[@class = 'title' and text() = 'Избранное']]");

        addToCart = Selenide.$x("//mvid-header-icon[.//p[@class = 'title' and text() = 'Корзина']]");

        addNumberOnTheCart = Selenide.$x("//div[contains(@class, 'tab-cart')]//mvid-bubble");

        inputLine = Selenide.$x("//mvid-input[contains(@class, 'search-input ng-tns-c230-1')]//input");

        buttonSearch = Selenide.$x("//div[contains(@class, 'search-icon-wrap ng-star-inserted')]");

        formRegistration = Selenide.$x("//form[contains(@class, 'login-form ng-untouched ng-pristine ng-valid')]");

        titleLoginOrRegistration = Selenide.$x("//form[contains(@class, 'login-form ng-untouched ng-pristine ng-valid')]/h2[text() = ' Вход или регистрация ']");

        phoneInputField = Selenide.$x("//div[contains(@class, 'form-field__label-container')]//span[text() = 'Телефон']");

        buttonContinue = Selenide.$x("//button[./div[@class = 'mv-main-button--content' and text() = ' Продолжить ']]");

        linkLegalEntities = Selenide.$x("//div[contains(@class, 'column--link-btn')]/button[text() = '  Для юридических лиц ']");

        amountsItemsInComparison = Selenide.$x("//mvid-header-icon[@buttontext='Сравнить товары']//mvid-bubble");

        amountsItemsInFavorites = Selenide.$x("//mvid-header-icon[@buttontext='К списку избранного']//mvid-bubble");

        locationButton = Selenide.$x("//div[contains(@class, 'location ng-tns-c230-1')]");

        windowSelectCity = Selenide.$x("//div[contains(@class, 'modal-layout')][.//h3[contains(text(), 'Выберите город')]]");

    }

    public SelenideElement getStatusOrder(){return addStatusOrder;}
    public SelenideElement getRegistration(){return addRegistration;}
    public SelenideElement getComparison(){return addComparison;}
    public SelenideElement getFavorites(){return addFavorites;}
    public SelenideElement getAddToCart(){return addToCart;}
    public SelenideElement getInputLine(){return inputLine;}
    public SelenideElement getButtonSearch(){return buttonSearch;}
    public SelenideElement getFormRegistration(){return formRegistration;}
    public SelenideElement getTitleLoginOrRegistration(){return titleLoginOrRegistration;}
    public SelenideElement getPhoneInputField(){return phoneInputField;}
    public SelenideElement getButtonContinue(){return buttonContinue;}
    public SelenideElement getLinkLegalEntities(){return linkLegalEntities;}
    public SelenideElement getLocationButton(){return locationButton;}
    public SelenideElement getWindowSelectCity(){return windowSelectCity;}


    public  boolean checkForDisplay(SelenideElement elem){
        return elem.isDisplayed();
    }

    public boolean checkForEnabled(SelenideElement element) {
        String strClassAttribute = getClassAttribute(element);
        return !(Objects.nonNull(strClassAttribute) && strClassAttribute.contains("disabled"));
    }

    private String getClassAttribute(SelenideElement element) {
        return element.getAttribute("class");
    }

    private String getDisabledAttribute(){
        return getButtonContinue().getAttribute("disabled");
    }

    public boolean checkForDisabled() {
        String strDisabledAttribute = getDisabledAttribute();
        return !(Objects.nonNull(strDisabledAttribute) && strDisabledAttribute.contains("true"));
    }

    public void getNumberOnTheCart(String amount){
        addNumberOnTheCart.shouldBe(Condition.text(amount));
    }


    public void click(SelenideElement element){
        element.scrollIntoView("{block: \"center\"}").shouldBe(Condition.visible).click();
    }

    public void enterValue(String value){
        inputLine.setValue(value);
    }

    public String getEnterValue(){
        return inputLine.getValue();
    }

    public void getNumberOnComparison(String amount){
        amountsItemsInComparison.shouldBe(Condition.text(amount));
    }

    public void getNumberOnFavorites(String amount){
        amountsItemsInFavorites.shouldBe(Condition.text(amount));
    }

    public void findCity(String city){
        $x("//ul[contains(@class, 'location-select__location-list')]/li[contains(text(), '"+city+"')]").scrollIntoView("{block: 'center'}").click();
    }

    public boolean displayedLocator(String text){
       return locationButton.shouldBe(Condition.text(text)).isDisplayed();

    }
    public void closeForModalWindow(){
        windowSelectCity.shouldBe(Condition.hidden);

    }

}
