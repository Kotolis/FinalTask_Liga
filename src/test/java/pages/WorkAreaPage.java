package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import session.PriceNameButtonBueForCard;
import com.codeborne.selenide.Condition;

public class WorkAreaPage {

    private SelenideElement addToCartProductDay;
    private SelenideElement addBlockWithProductDay;
    private SelenideElement addTitleProductDay;
    private SelenideElement addTitleMostViewed;
    private SelenideElement addBlockMostViewed1;
    private SelenideElement addBlockMostViewedWithText;
    private SelenideElement addBlockMostViewed2;

    public WorkAreaPage() {
        addToCartProductDay = Selenide.$x("//mvid-day-product[contains(@class, ' main ng-star-inserted')]/button");

        addBlockWithProductDay = Selenide.$x("//mvid-day-products-block[.//span[@class = 'title__text' and text() = 'Товары дня']]");

        addTitleProductDay = Selenide.$x("//mvid-day-products-block[contains(@class, 'block ng-star-inserted')]//div[contains(@class, 'title ng-star-inserted')]/a");

        addTitleMostViewed = Selenide.$x("//h2[@class = 'title ng-star-inserted' and text() = 'Самые просматриваемые']");

        addBlockMostViewed1 = Selenide.$x("//mvid-simple-product-collection-mp[1]");

        addBlockMostViewedWithText = Selenide.$x("//mvid-simple-product-collection-mp[1]//h2[text() = 'Самые просматриваемые']");

        addBlockMostViewed2 = Selenide.$x("//mvid-simple-product-collection-mp[2]");


    }

    @FindBy(xpath = "//h2[contains(text(), 'Самые просматриваемые')]/..//a/div[text() != '']")
    private ElementsCollection nameMostViewed;

    @FindBy(xpath = "//h2[contains(text(), 'Самые просматриваемые')]/..//span[contains(@class, 'price__main-value')]")
    private ElementsCollection priceMostViewed;

    @FindBy(xpath = "//h2[contains(text(), 'Самые просматриваемые')]/..//mvid-icon[@type='cart']/..")
    private ElementsCollection addToCartMostViewed;


    public SelenideElement buttonAddToCartProductDay(){return addToCartProductDay;}

    public SelenideElement blockWithProductDay(){return addBlockWithProductDay;}

    public SelenideElement titleProductDay(){return addTitleProductDay;}

    public SelenideElement getTitleMostViewed(){return addTitleMostViewed;}

    public SelenideElement getBlockMostViewedWithText(){return addBlockMostViewedWithText;}

    public SelenideElement getBlockMostViewed2(){return addBlockMostViewed2;}



    public void addToCartProductDayDisplayed(){
        if(buttonAddToCartProductDay().isDisplayed()){
            buttonAddToCartProductDay().scrollIntoView("{block: \"center\"}").click();
            buttonAddToCartProductDay().shouldBe(Condition.visible);
        }
    }

   // public String getTitleProductDay(){
   //     return titleProductDay().getText();
   // }

    public void addMultipleProducts(){
        PriceNameButtonBueForCard.clearCartList();
        PriceNameButtonBueForCard.elementsCard(nameMostViewed, priceMostViewed, addToCartMostViewed);

    }
    public void clickMostViewedProducts(int productNumber){
        PriceNameButtonBueForCard.goods.get(productNumber-1).button.scrollIntoView("{block: \"center\"}").click();

    }
    public void titleMostViewedVisible(){
        addTitleMostViewed.shouldBe(Condition.visible);
    }


    public void scrollToFirstBlockMostViewed(){
        addBlockMostViewed1.scrollIntoView("{block: \"center\"}");
    }




}
