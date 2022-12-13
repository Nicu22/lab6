package Controller;

import Model.Bar;
import Model.European;
import Model.Sushi;

interface clientSpecial{
    void clientWedding();
    void spousesLeft();
}

public class Client extends Person implements clientSpecial {
    public int number;
    boolean hasOrder = false;
    public Waiter waiter;
    public Bar b1;
    public European e1;
    public Sushi s1;
    public Client(String Name, int Number, Waiter waiter, Bar b1, European e1, Sushi s1){
        super(Name);
        number = Number;
        this.waiter = waiter;
        this.b1 = b1;
        this.e1 = e1;
        this.s1 = s1;
        arrived();
    }
    //the basic func of our class
    @Override
    void showName(){
        System.out.println("Controler.Client name is " + name);
    }
    void arrived(){//Controler.Client arrived
        System.out.println("\nControler.Client "+ number + " has arrived " + name +".This Controler.Client waiter is "+ waiter.name +"\n");
    }
    int order() {
        System.out.println("Controler.Client " + number + " made the order\n");
        int chanceMenu = (int) ((Math.random() * (4 - 1)) + 1);
        int price = 0;
        //menu bar
        int rand = (int) ((Math.random() * (100 - 1)) + 1);
        if(chanceMenu ==1) {
            if (rand < 33) {
                int chance = (int) ((Math.random() * (4 - 1)) + 1);
                if (chance == 1) {
                    price = price + b1.barMenu.get("Enzo");
                } else if (chance == 2) {
                    price = price + b1.barMenu.get("Martini");
                } else {
                    price = price + b1.barMenu.get("B52");
                }
            }
        }
        //menu bar
        else if (chanceMenu ==2) {
            if (rand < 33) {
                int chance = (int) ((Math.random() * (4 - 1)) + 1);
                if (chance == 1) {
                    price = price + s1.sushiMenu.get("Naghiri");
                } else if (chance == 2) {
                    price = price + s1.sushiMenu.get("Dragon Rolls");
                } else {
                    price = price + s1.sushiMenu.get("Poke Bowl");
                }
            }
        }
        else {
            //menu european
            if (rand < 33) {
                int chance = (int) ((Math.random() * (4 - 1)) + 1);
                if (chance == 1) {
                    price = price + e1.euroMenu.get("Zeama UTM");
                } else if (chance == 2) {
                    price = price + e1.euroMenu.get("Pasta Pardono");
                } else {
                    price = price + e1.euroMenu.get("Lovele Saltele");
                }
            }
        }
        return price;
    }
    void left(){System.out.println("Controler.Client "+ number + " has left\n");}
    void complaint(){
        System.out.println("Controler.Client "+ number+ " complained about the food\n");
    }


    //for the Controler.clientSpecial interface
    public void clientWedding() {
        System.out.println("*CThe restaurant is booked for a wedding today*");
    }
    public void spousesLeft() {
        System.out.println("Our clients left. Our special event is over. \n");
    }
}
