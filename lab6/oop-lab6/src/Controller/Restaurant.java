package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Restaurant {
    HashMap<Client, Integer> clientList = new HashMap<Client, Integer>();
    ArrayList<Waiter> waiterList = new ArrayList<Waiter>();
    int restaurantCapacity = 30;
    int wageBill = 350;
    Manager manager = new Manager("Ion","General Controler.Manager");
    int clientsPerWaiter = 5;
    int budgetPerDay = 0;
    Restaurant(){
        ArrayList<String> names = new ArrayList<>();
        try {
            File myObj = new File("names.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                names.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i = 0; i < 20; i++ ){
            int rand = (int) ((Math.random() * (names.size() - 1)) + 1);
            waiterList.add(new Waiter(names.get(rand),manager));
        }
    }

    Optional<Waiter> getAvailableWaiter(){
        for (int i = 0; i < waiterList.size(); i++){
            int clients = 0;
            for (Client j : clientList.keySet()){
                if (j.waiter.equals(waiterList.get(i))){
                    clients ++;
                }
            }
            if(clients < clientsPerWaiter){
                return Optional.of(waiterList.get(i));
            }
        }
        return Optional.empty();
    }

}
