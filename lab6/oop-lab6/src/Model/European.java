package Model;



import java.util.HashMap;

public class European extends Section {

    public HashMap<String, Integer> euroMenu = new HashMap<String, Integer>();
    public European(String Name) {
        super(Name);
        euroMenu.put("Zeama UTM", 15);
        euroMenu.put("Pasta Pardono", 20);
        euroMenu.put("Lovele Saltele", 35);
    }

    @Override
    public void fire(){
        System.out.println("*" + name + " section is on fire*");
    }
}
