package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import session.PriceNameButtonBueForCard;

public class ProductPage {

    private SelenideElement pageArea;
    private SelenideElement firstContainer;
    private SelenideElement filterSort;
    private SelenideElement containerFiltersSort;
    private SelenideElement filterFirstMoreExpensive;

    public ProductPage(){
        pageArea = Selenide.$x("//div[contains(@class, 'plp__card-grid')]");

        firstContainer = Selenide.$x("//div[contains(@class, 'ng-star-inserted product-cards-row')][1]");

        filterSort = Selenide.$x("//mvid-dropdown[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'Сначала популярные')]");

        containerFiltersSort = Selenide.$x("//mvid-product-list-controls[contains(@class, 'ng-star-inserted')]//div[contains(@class, 'dropdown__options')]");

        filterFirstMoreExpensive = Selenide.$x("//div[contains(text(), 'Сначала дороже')]");

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

    public void addPageAreaProducts() {
        PriceNameButtonBueForCard.clearCartList();
        PriceNameButtonBueForCard.elementsCard(elementsWithName, elementsWithPrice, elementsButtonAddCart);

    }

    public void scrollPageProduct () {
        pageArea.shouldBe(Condition.visible);
        Selenide.sleep(4000);
        //firstContainer.shouldBe(Condition.visible);
        //Selenide.sleep(4000);
        for (int i = 0; i < elementsWithName.size(); i++) {
            elementsWithName.get(i).shouldBe(Condition.visible).scrollIntoView("{block: \"center\"}");
        }
    }

    public boolean checkAppleName(){
        boolean flag = true;

        for (int i = 0; i < PriceNameButtonBueForCard.goods.size(); i++){
            if(!PriceNameButtonBueForCard.goods.get(i).name.toLowerCase().contains("apple")){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean priceComparison(){
        boolean flag = true;
        for (int i = 0; i < PriceNameButtonBueForCard.goods.size()-1; i++){
            if(PriceNameButtonBueForCard.goods.get(i).price >= PriceNameButtonBueForCard.goods.get(i+1).price){
                flag = true;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
