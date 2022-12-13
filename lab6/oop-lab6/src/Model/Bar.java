package Model;



import java.util.HashMap;

public class Bar extends Section {
    public HashMap<String, Integer> barMenu = new HashMap<String, Integer>();

    public Bar(String Name) {
        super(Name);
        barMenu.put("Enzo", 50);
        barMenu.put("Martini", 20);
        barMenu.put("B52", 40);
    }

    @Override
    public void fire(){
        System.out.println("*" + name + " section is on fire*");
    }
}
