package session;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

public class PriceNameButtonBueForCard {

    public String name;
    public int price;
    public SelenideElement button;

    public static ArrayList<PriceNameButtonBueForCard> goods = new ArrayList<>();

    public static void elementsCard(ElementsCollection name, ElementsCollection price, ElementsCollection button){
        int count = name.size();
        for (int i = 0; i<count; i++){
            goods.add(new PriceNameButtonBueForCard(name.get(i).text(),Integer.parseInt(price.get(i).text().replaceAll("\\D+","")), button.get(i)));
        }

    }


    public static void clearCartList(){
        goods.clear();
    }

    public PriceNameButtonBueForCard(String name, int price,SelenideElement button){
        this.name=name;
        this.price=price;
        this.button=button;
    }



}
