package Model;

abstract class List extends Object {
    public String name;
    List(String Name){
        name = Name;
    }
    void showListName(){
        System.out.println(name);
    }

}
