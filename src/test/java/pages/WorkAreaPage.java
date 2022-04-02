package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import session.PriceNameButtonBueForCard;

public class WorkAreaPage {

    private SelenideElement addToCartProductDay;
    private SelenideElement addBlockWithProductDay;
    private SelenideElement addTitleMostViewed;
    private SelenideElement addBlockMostViewed1;
    private SelenideElement addBlockMostViewedWithText;
    private SelenideElement addBlockMostViewed2;


    public WorkAreaPage() {
        addToCartProductDay = Selenide.$x("//mvid-day-product[contains(@class, ' main ng-star-inserted')]/button");

        addBlockWithProductDay = Selenide.$x("//mvid-day-products-block[.//span[@class = 'title__text' and text() = 'Товары дня']]");

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

    public SelenideElement getTitleMostViewed(){return addTitleMostViewed;}

    public SelenideElement getBlockMostViewedWithText(){return addBlockMostViewedWithText;}

    public SelenideElement getBlockMostViewed2(){return addBlockMostViewed2;}



    public void addToCartProductDayDisplayed(){
        if(buttonAddToCartProductDay().isDisplayed()){
            buttonAddToCartProductDay().scrollIntoView("{block: \"center\"}").click();
            buttonAddToCartProductDay().shouldBe(Condition.visible);
        }
    }

    public void addMultipleProducts(){
        PriceNameButtonBueForCard.clearCartList();
        PriceNameButtonBueForCard.elementsCard(nameMostViewed, priceMostViewed, addToCartMostViewed);
    }


    public void clickFewProducts(int productNumber){
        PriceNameButtonBueForCard.goods.get(productNumber-1).button.scrollIntoView("{block: \"center\"}").click();
        PriceNameButtonBueForCard.comparisonElements.add(PriceNameButtonBueForCard.goods.get(productNumber-1));
        System.out.println("я добавил "+PriceNameButtonBueForCard.goods.get(productNumber-1).name+ " в "+ PriceNameButtonBueForCard.comparisonElements);
        System.out.println(PriceNameButtonBueForCard.comparisonElements);
    }

    public void titleMostViewedVisible(){
        addTitleMostViewed.shouldBe(Condition.visible);
    }

    public void scrollToFirstBlockMostViewed(){
        addBlockMostViewed1.scrollIntoView("{block: \"center\"}");
    }

    public void buttonDisplayForDownloadVerification(){
        addToCartProductDay.shouldBe(Condition.visible);
    }



}
