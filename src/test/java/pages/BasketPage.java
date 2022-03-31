package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.FindBy;
import session.PriceNameButtonBueForCard;

public class BasketPage {
    private SelenideElement addTitleBasket;
    private SelenideElement addTitleProductInBasket;
    private SelenideElement addTextAmountProducts;
    private SelenideElement addOrderingButton;
    private SelenideElement addCardPrice;
    private SelenideElement addOrderPrice;
    private SelenideElement addSumProduct;

    public BasketPage() {
        addTitleBasket = Selenide.$x("//span[@class = 'c-header-checkout__logo u-ml-0' and text() = 'Моя корзина']");

        addTitleProductInBasket = Selenide.$x("//div[contains(@class, 'c-cart-item__header')]/a[contains(@class, 'c-link ')]");

        addTextAmountProducts = Selenide.$x("//span[contains(@class, 'c-cost-line__title')]");

        addOrderingButton = Selenide.$x("//input[contains(@value,'Перейти к оформлению')]");

        addCardPrice = Selenide.$x("//span[contains(@class, 'c-cart-item__price')]");

        addOrderPrice = Selenide.$x("//span[contains(@class, 'c-cost-line__text')]");

        addSumProduct = Selenide.$x("//span[contains(@class, 'c-cost-line__text')]");


    }

    public SelenideElement getTitleBasket(){return addTitleBasket;}

    public SelenideElement titleProductInBasket(){return addTitleProductInBasket;}

    public SelenideElement textAmountProducts(){return addTextAmountProducts;}

    public SelenideElement getOrderingButton(){return addOrderingButton;}


    @FindBy(xpath = "//a[contains(@class, 'c-cart-item__title')]")
    private ElementsCollection addAllTitleInCart;

    @FindBy(xpath = "//span[contains(@class, 'c-cart-item__price')]")
    private ElementsCollection addAllPriceInCart;

    @FindBy(xpath = "//button[contains(@class, 'c-counter-input__plus-btn c-counter-input__btn ')]")
    private ElementsCollection addAllButtonPlus;


    //public String getTitleProductInBasket(){
     //   return titleProductInBasket().getText();
    //}

     public String getTextAmountProducts(){
        return textAmountProducts().getText();
     }

     public int getCardPrice(){
        return Integer.parseInt(addCardPrice.getText());
     }

     public int getOrderPrice(){
        return Integer.parseInt(addOrderPrice.getText());
     }

    public boolean comparisonNameInMainPageAndCart() {
        boolean flag = true;
        for (int i = 0; i < addAllTitleInCart.size(); i++) {
            if (addAllTitleInCart.get(i).text().equals(PriceNameButtonBueForCard.goods.get(i).name)) {
            } else {
                flag = false;
            }
        }
        return flag;

    }

    public boolean comparisonPriceInCart(){
         boolean flag = true;
         int counter = 0;
         int sumProduct = Integer.parseInt(addSumProduct.text().replaceAll("\\D+",""));

         for (int i = 0; i < PriceNameButtonBueForCard.goods.size(); i++){
             counter += PriceNameButtonBueForCard.goods.get(i).price;
         }
         if (sumProduct!=counter){
             System.out.println(sumProduct);
             flag = false;
         }
         return flag;

    }

    public void addElementsCart(){
        PriceNameButtonBueForCard.clearCartList();
        PriceNameButtonBueForCard.elementsCard(addAllTitleInCart,addAllPriceInCart,addAllButtonPlus);
    }




}
