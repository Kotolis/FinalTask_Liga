package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import session.PriceNameButtonBueForCard;

public class BasketPage {
    private SelenideElement addTitleBasket;
    private SelenideElement addTextAmountProducts;
    private SelenideElement addOrderingButton;
    private SelenideElement addCardPrice;
    private SelenideElement addOrderPrice;
    private SelenideElement addSumProduct;


    public BasketPage() {
        addTitleBasket = Selenide.$x("//span[@class = 'c-header-checkout__logo u-ml-0' and text() = 'Моя корзина']");

        addTextAmountProducts = Selenide.$x("//span[contains(@class, 'c-cost-line__title')]");

        addOrderingButton = Selenide.$x("//input[contains(@value,'Перейти к оформлению')]");

        addCardPrice = Selenide.$x("//span[contains(@class, 'c-cart-item__price')]");

        addOrderPrice = Selenide.$x("//span[contains(@class, 'c-cost-line__text')]");

        addSumProduct = Selenide.$x("//span[contains(@class, 'c-cost-line__text')]");



    }

    public SelenideElement getTitleBasket(){return addTitleBasket;}

    public SelenideElement textAmountProducts(){return addTextAmountProducts;}

    public SelenideElement getOrderingButton(){return addOrderingButton;}



    @FindBy(xpath = "//a[contains(@class, 'c-cart-item__title')]")
    private ElementsCollection addAllTitleInCart;

    @FindBy(xpath = "//span[contains(@class, 'c-cart-item__price')]")
    private ElementsCollection addAllPriceInCart;

    @FindBy(xpath = "//button[contains(@class, 'c-counter-input__plus-btn c-counter-input__btn ')]")
    private ElementsCollection addAllButtonPlus;


     public String getTextAmountProducts(){
        return textAmountProducts().getText();
     }

     public int getCardPrice(){
        return Integer.parseInt(addCardPrice.text().replaceAll("\\D+",""));
     }

     public int getOrderPrice(){
         return Integer.parseInt(addOrderPrice.text().replaceAll("\\D+",""));
     }

    public boolean comparisonNameInMainPageAndCart() {
        boolean flag = true;
        for (int i = 0; i < addAllTitleInCart.size(); i++) {
            System.out.println("Итерация номер " + i);
            if (addAllTitleInCart.get(i).text().equals(PriceNameButtonBueForCard.goods.get(i).name)) {
                System.out.println("Имя " + addAllTitleInCart.get(i).text() + "равно имени " + PriceNameButtonBueForCard.goods.get(i).name);
            } else {
                System.out.println(addAllTitleInCart.get(i).text() + "не равно имени " + PriceNameButtonBueForCard.goods.get(i).name);
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
             System.out.println(sumProduct + "не равно "+ counter);
             flag = false;
         }
         return flag;

    }

    public void addElementsCart(){
        PriceNameButtonBueForCard.clearCartList();
        PriceNameButtonBueForCard.elementsCard(addAllTitleInCart,addAllPriceInCart,addAllButtonPlus);
    }




}
