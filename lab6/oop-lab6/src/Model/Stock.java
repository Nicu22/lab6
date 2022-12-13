package Model;

import java.util.ArrayList;

public class Stock extends List {

    public ArrayList<String> item;

    public Stock(String Name){
        super(Name);
        item = new ArrayList<>();
        item.add("Kitchen stock is at ");
        item.add("Model.Bar stock is at ");
        item.add("Model.Sushi stock is at ");
    }

    void showElements(){
        int min = 1;
        int max = 100;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        for(int i = 0; i < item.size(); i++){
            System.out.println(item.get(i) + random_int + "%.");
        }
        System.out.println("Stocks below 20% should be replaced tomorrow\n");
    }
}
