package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import session.ComparisonCardsElements;
import session.PriceNameButtonBueForCard;

import java.util.ArrayList;

public class ComparisonPage {

    private SelenideElement titleComparisonPage;

    public ComparisonPage() {
        titleComparisonPage = Selenide.$x("//div[contains(@class, 'c-compare-head-title')]/h1[text() = 'Сравнение товаров']");

    }

    @FindBy(xpath = "//div[contains(@class, 'pinable-product-tile')]/..//a[contains(@class, 'fl-product-tile-title__link')]")
    private ElementsCollection nameProductInComparison;

    @FindBy(xpath = "//div[contains(@class, 'pinable-product-tile')]/..//span[contains(@class, 'fl-product-tile-price__current')]")
    private ElementsCollection priceProductInComparison;

    @FindBy(xpath = "//div[contains(@class, 'pinable-product-tile')]/..//span[contains(@class, 'c-btn__text')]")
    private ElementsCollection buttonProductInComparison;

    public SelenideElement getTitleComparisonPage() {
        return titleComparisonPage;
    }

    public void addElementsComparisonPage(){
        ComparisonCardsElements.clearCartList();
        ComparisonCardsElements.cardForElements(nameProductInComparison, priceProductInComparison,buttonProductInComparison);
    }

    public boolean comparisonNameInProductAndComparisonPage() {
        boolean flag = true;
        ArrayList<String> listNameComparison = new ArrayList<String>();
        //System.out.println("Начинаю сравнивать то что добавлял и что добавилось, сначала сверю размер списков");
        for (int i =0;i<PriceNameButtonBueForCard.comparisonElements.size();i++){
            listNameComparison.add(PriceNameButtonBueForCard.comparisonElements.get(i).name);
        }
        if (nameProductInComparison.size() == listNameComparison.size()) {
            for (int i = 0; i < listNameComparison.size(); i++) {
                //System.out.println("Содержится ли элемент "+ComparisonCardsElements.card.get(i).name + " в списке");
                if (listNameComparison.contains(ComparisonCardsElements.card.get(i).name)) {
                    //System.out.println("Условие прошло у нас есть "+ComparisonCardsElements.card.get(i).name+ " в:");
                    for (int j =0; j<PriceNameButtonBueForCard.comparisonElements.size();j++){
                       // System.out.println(PriceNameButtonBueForCard.comparisonElements.get(j).name);
                    }
                } else {
                   // System.out.println("Условие не прошло у нас нет "+ComparisonCardsElements.card.get(i).name+ " в:");
                    for (int j =0; j<PriceNameButtonBueForCard.comparisonElements.size();j++){
                       // System.out.println(PriceNameButtonBueForCard.comparisonElements.get(j).name);
                    }
                    flag = false;
                    break;
                }
            }
        }else {
            System.out.println(nameProductInComparison.size()+ " не равен размеру "+ PriceNameButtonBueForCard.comparisonElements.size());
            flag = false;
        }
        return flag;
    }
}
