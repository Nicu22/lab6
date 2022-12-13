package Controller;

interface clientDisputes{
    void escortClientOut();
}

interface managerResponsibility {
    void escortFire();
}
public class Manager extends Person implements clientDisputes, managerResponsibility {

    public String position;
    public String waiterName;
    Manager(String Name, String Position){
        super(Name);
        position = Position;
    }


    //base func for our class

    String getManName(){
        return name;
    }
    @Override
    void showName(){
        System.out.println("I am the manager, " + name+ ", I am the " + position + ". What can I help you with?");
    }
    void openRestaurant(){
        System.out.println("Restaurant UTM is now open\n");
    }
    void closeRestaurant(){
        System.out.println("The Controler.Restaurant has been closed\n");
    }

    //func for ClientDisputes interface
    public void escortClientOut() {
        System.out.println("The manager escorted the client out\n");
    }
    public void newFood(){
        System.out.println("Controler.Manager brought new food\n");
    }
    //func for the Controler.managerResponsibility interface
    public void escortFire() {
        System.out.println("Fire broke out. The manager escorted the clients\n");
    }
}
