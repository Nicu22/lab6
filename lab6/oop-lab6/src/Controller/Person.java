package Controller;

abstract class Person extends Object {
    public String name;
    public Person(String Name){
        name = Name;
    }
    void showName(){
        System.out.println("My name is " + name);
    }
}
