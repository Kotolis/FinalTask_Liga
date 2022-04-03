package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import session.ComparisonCardsElements;
import session.PriceNameButtonBueForCard;

import java.util.ArrayList;

public class FavoritesPage {

    private SelenideElement titleFavoritesPage;
    private SelenideElement nameForCheckPageLoad;

    public FavoritesPage() {

        titleFavoritesPage = Selenide.$x("//h1[contains(text(), 'Избранное')]");
        nameForCheckPageLoad = Selenide.$x("//h3[contains(@class, 'wishlist-product-title')]/a[1]");

    }

    public SelenideElement getTitleFavoritesPage() {
        return titleFavoritesPage;
    }

    @FindBy(xpath = "//h3[contains(@class, 'wishlist-product-title')]/a")
    private ElementsCollection nameProductInFavorites;

    @FindBy(xpath = "//div[contains(@class, 'wishlist-price__current')]")
    private ElementsCollection priceProductInFavorites;

    @FindBy(xpath = "//button[contains(@class, ' c-btn_text-hidden-mobile ')]//span")
    private ElementsCollection buttonProductsInFavorites;

    public void addElementsFavoritesPage(){
        ComparisonCardsElements.clearCartList();
        ComparisonCardsElements.cardForElements(nameProductInFavorites, priceProductInFavorites,buttonProductsInFavorites);
    }


    public void scrollPageFavorites() {
        nameForCheckPageLoad.shouldBe(Condition.visible);
        for (int i = 0; i < nameProductInFavorites.size(); i++) {
            nameProductInFavorites.get(i).shouldBe(Condition.visible).scrollIntoView("{block: \"center\"}");
        }
    }

    public boolean comparisonNameInProductAndFavoritesPage() {
        boolean flag = true;
        ArrayList<String> listNameFavorites = new ArrayList<String>();
        //System.out.println("Начинаю сравнивать то что добавлял и что добавилось, сначала сверю размер списков");
        for (int i = 0; i < PriceNameButtonBueForCard.comparisonElements.size(); i++) {
            listNameFavorites.add(PriceNameButtonBueForCard.comparisonElements.get(i).name);
        }
        if (nameProductInFavorites.size() == listNameFavorites.size()) {
            for (int i = 0; i < listNameFavorites.size(); i++) {
                //System.out.println("Содержится ли элемент " + ComparisonCardsElements.card.get(i).name + " в списке");
                if (listNameFavorites.contains(ComparisonCardsElements.card.get(i).name)) {
                   // System.out.println("Условие прошло у нас есть " + ComparisonCardsElements.card.get(i).name + " в:");
                    for (int j = 0; j < PriceNameButtonBueForCard.comparisonElements.size(); j++) {
                       // System.out.println(PriceNameButtonBueForCard.comparisonElements.get(j).name);
                    }
                } else {
                    System.out.println("Условие не прошло у нас нет " + ComparisonCardsElements.card.get(i).name + " в:");
                    for (int j = 0; j < PriceNameButtonBueForCard.comparisonElements.size(); j++) {
                       // System.out.println(PriceNameButtonBueForCard.comparisonElements.get(j).name);
                    }
                    flag = false;
                    break;
                }
            }
        } else {
            System.out.println(nameProductInFavorites.size() + " не равен размеру " + PriceNameButtonBueForCard.comparisonElements.size());
            flag = false;
        }
        return flag;
    }
}






