package Model;

import java.util.HashMap;

public class Sushi extends Section {


    public HashMap<String, Integer> sushiMenu = new HashMap<String, Integer>();
    public Sushi(String Name) {
        super(Name);
        sushiMenu.put("Naghiri", 25);
        sushiMenu.put("Dragon Rolls", 30);
        sushiMenu.put("Poke Bowl", 20);
    }
    @Override
    public void fire(){
        System.out.println("*" + name + " section is on fire*");
    }
}
