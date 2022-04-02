package session;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

public class ComparisonCardsElements {

    public String name;
    public int price;
    public SelenideElement button;

    public static ArrayList<ComparisonCardsElements> card = new ArrayList<>();


    public static void cardForElements(ElementsCollection name, ElementsCollection price, ElementsCollection button){
        int count = name.size();
        for (int i = 0; i<count; i++){
            card.add(new ComparisonCardsElements(name.get(i).text(),Integer.parseInt(price.get(i).text().replaceAll("\\D+","")), button.get(i)));
        }

    }


    public static void clearCartList(){
        card.clear();
    }


    public ComparisonCardsElements(String name, int price,SelenideElement button){
        this.name=name;
        this.price=price;
        this.button=button;
    }

}
