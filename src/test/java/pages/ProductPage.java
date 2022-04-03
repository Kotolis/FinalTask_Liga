package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import session.PriceNameButtonBueForCard;

public class ProductPage {

    private SelenideElement pageArea;
    private SelenideElement filterSort;
    private SelenideElement containerFiltersSort;
    private SelenideElement filterFirstMoreExpensive;
    private SelenideElement nameToCheckPageLoad;

    public ProductPage(){
        pageArea = Selenide.$x("//div[contains(@class, 'plp__card-grid')]");

        filterSort = Selenide.$x("//mvid-dropdown[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'Сначала популярные')]");

        containerFiltersSort = Selenide.$x("//mvid-product-list-controls[contains(@class, 'ng-star-inserted')]//div[contains(@class, 'dropdown__options')]");

        filterFirstMoreExpensive = Selenide.$x("//div[contains(text(), 'Сначала дороже')]");

        nameToCheckPageLoad = Selenide.$x("//a[contains(@class, 'product-title__text product-title--clamp')][1]");

    }

    public SelenideElement getPageArea(){return pageArea;}

    public SelenideElement getFilterSort(){return filterSort;}

    public SelenideElement getContainerFiltersSort(){return containerFiltersSort;}

    public SelenideElement getFilterFirstMoreExpensive(){return filterFirstMoreExpensive;}


    @FindBy(xpath = "//a[contains(@class, 'product-title__text product-title--clamp')]")
    private ElementsCollection elementsWithName;

    @FindBy(xpath = "//span[contains(@class, 'price__main-value')]")
    private ElementsCollection elementsWithPrice;

    @FindBy(xpath = "//mvid-button[contains(@class, 'flexible-width button_without-icon')]//span")
    private ElementsCollection elementsButtonAddCart;

    @FindBy(xpath = "//div[contains(@class, 'product-checkout__button compare-button-block ng-star-inserted')]")
    private ElementsCollection buttonComparison;

    @FindBy(xpath = "//div[contains(@class, 'product-checkout__button wishlist-button-block ng-star-inserted')]")
    private ElementsCollection buttonFavorites;


    public void addPageAreaProducts() {
        PriceNameButtonBueForCard.clearCartList();
        PriceNameButtonBueForCard.elementsCard(elementsWithName, elementsWithPrice, elementsButtonAddCart);

    }
    public void addPageAreaProductsComparison(){
        PriceNameButtonBueForCard.clearCartList();
        PriceNameButtonBueForCard.elementsCard(elementsWithName, elementsWithPrice,buttonComparison);
    }

    public void addPageAreaProductsFavorites(){
        PriceNameButtonBueForCard.clearCartList();
        PriceNameButtonBueForCard.elementsCard(elementsWithName, elementsWithPrice,buttonFavorites);
    }

    public void scrollPageProduct() {
        nameToCheckPageLoad.shouldBe(Condition.visible);
        for (int i = 0; i < elementsWithName.size(); i++) {
            elementsWithName.get(i).shouldBe(Condition.visible).scrollIntoView("{block: \"center\"}");
        }
    }


    public boolean checkAppleName(){
        boolean flag = true;

        for (int i = 0; i < PriceNameButtonBueForCard.goods.size(); i++){
            if(!PriceNameButtonBueForCard.goods.get(i).name.toLowerCase().contains("apple")){
                //System.out.println(PriceNameButtonBueForCard.goods.get(i).name + "не содержит apple");
                flag = false;
                break;
            }//System.out.println(PriceNameButtonBueForCard.goods.get(i).name + " содержит apple");
        }
        return flag;
    }

    public boolean priceComparison(){
        boolean flag = true;
        for (int i = 0; i < PriceNameButtonBueForCard.goods.size()-1; i++){
            if(PriceNameButtonBueForCard.goods.get(i).price >= PriceNameButtonBueForCard.goods.get(i+1).price){
                //System.out.println(PriceNameButtonBueForCard.goods.get(i).price + "больше или равно " + PriceNameButtonBueForCard.goods.get(i+1).price);
                flag = true;
            }else {
                //System.out.println(PriceNameButtonBueForCard.goods.get(i).price + "меньше " + PriceNameButtonBueForCard.goods.get(i+1).price);
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void nameProductToCheckPageLoad(){
        nameToCheckPageLoad.shouldBe(Condition.visible);

    }
    public void clearComparisonList(){
        PriceNameButtonBueForCard.clearComparisonList();
    }

}
