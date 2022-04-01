package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import session.PriceNameButtonBueForCard;

public class ComparisonPage {

    private SelenideElement titleComparisonPage;
    private SelenideElement closeAlert;

    public ComparisonPage(){
        titleComparisonPage = Selenide.$x("//div[contains(@class, 'c-compare-head-title')]/h1[text() = 'Сравнение товаров']");
        closeAlert = Selenide.$x("//a[contains(@class, 'close')]");

    }

    @FindBy(xpath = "//div[contains(@class, 'pinable-product-tile')]/..//a[contains(@class, 'fl-product-tile-title__link')]")
    private ElementsCollection nameProductInComparison;

    public SelenideElement getTitleComparisonPage(){return titleComparisonPage;}
    public SelenideElement getCloseAlert(){return closeAlert;}

    public boolean comparisonNameInProductAndComparisonPage(){
        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            if (nameProductInComparison.get(i).text().equals(PriceNameButtonBueForCard.goods.get(i).name)) {
                System.out.println(nameProductInComparison.get(i) + " " + PriceNameButtonBueForCard.goods.get(i).name);
            } else {
                flag = false;
            }
        }
        return flag;

    }


}
