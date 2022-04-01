package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import session.PriceNameButtonBueForCard;

public class FavoritesPage {

    private SelenideElement titleFavoritesPage;

    public FavoritesPage() {

        titleFavoritesPage = Selenide.$x("//h1[contains(text(), 'Избранное')]");

    }

    public SelenideElement getTitleFavoritesPage() {
        return titleFavoritesPage;
    }

    @FindBy(xpath = "//h3[contains(@class, 'wishlist-product-title')]")
    private ElementsCollection nameProductInFavorites;

    public boolean comparisonNameInProductAndFavoritesPage() {
        boolean flag = true;
        for (int i = 0; i < nameProductInFavorites.size(); i++) {
            if (nameProductInFavorites.get(i).text().equals(PriceNameButtonBueForCard.goods.get(i).name)) {
                System.out.println(nameProductInFavorites.get(i) + " " + PriceNameButtonBueForCard.goods.get(i).name);
            } else {
                flag = false;
            }
        }
        return flag;
    }
}

