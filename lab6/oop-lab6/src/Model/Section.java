package Model;

interface Hazard{
    void fire();
}
abstract class Section extends Object implements Hazard{
    public String name;
    Section(String Name){
        name = Name;
    }
    public void fire() {
        System.out.println("*" + name + " section is on fire*");
    }
}
