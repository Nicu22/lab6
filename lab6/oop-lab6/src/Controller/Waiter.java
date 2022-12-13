package Controller;

interface waiterDropsOrder{
    void dropOrder();
}

public class Waiter extends Person implements waiterDropsOrder{
    public Manager m1;
    public int clientNumber;
    public Waiter(String Name, Manager m1){
        super(Name);
        this.m1 = m1;
    }
    
    //basic func for out class
    @Override
    void showName(){
        System.out.println("I am waiter and My name is " + name);
    }
    public  void dropOrder(){
        System.out.println("The waiter dropped the order of client \n\nThe waiter brought a new order to the client\n");
    }

}
