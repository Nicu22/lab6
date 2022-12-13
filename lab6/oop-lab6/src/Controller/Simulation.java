package Controller;


import Model.*;

import java.time.LocalTime;
import java.util.*;

public class Simulation {
    Probability probability;
    Bar bar = new Bar("Model.Bar");
    European european = new European("Model.European");
    Sushi sushi = new Sushi("Model.Sushi");
    Stock stock = new Stock("Controler.Restaurant Model.Stock");
    Restaurant restaurant = new Restaurant();
    Random random = new Random();
    int clientNumber = 0;
    ArrayList<String> names;

    public Simulation(Probability probability){
        this.probability = probability;
    }

    void simulate() {
        names = Names.readNames();

        int rand = (int) ((Math.random() * (10 - 1)) + 1);

        if (rand/10 > probability.probabilityFire) {
            restaurant.manager.openRestaurant();
            int r = (int) ((Math.random() * (4 - 1)) + 1);
            String section;
            if (r == 1) {
                section = bar.name;
            } else if (r == 2) {
                section = sushi.name;
            } else {
                section = european.name;
            }
            System.out.println("A fire broke out at section" + section);
            restaurant.manager.escortFire();
            restaurant.manager.closeRestaurant();
        } else {
            restaurant.manager.closeRestaurant();
            int rand2 = (int) ((Math.random() * (10 - 1)) + 1);
            if (rand2/10 > probability.probabilityWedding) {
                for (Iterator<Map.Entry<Client, Integer>> it = restaurant.clientList.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<Client, Integer> entry = it.next();
                    entry.getKey().clientWedding();
                    entry.getKey().spousesLeft();
                }
                restaurant.manager.closeRestaurant();
            } else {
                restaurant.manager.openRestaurant();
                LocalTime time = LocalTime.parse("08:00");
                do {
                    System.out.println(time);
                    time = time.plusMinutes(15);
                    //manager
                    //int rand3 = (int) ((Math.random() * (names.size() - 1)) + 1);
                    int rand4 = (int) ((Math.random() * (100 - 1)) + 1);
                    for (Iterator<Map.Entry<Client, Integer>> it = restaurant.clientList.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<Client, Integer> entry = it.next();
                        if (entry.getKey().hasOrder && rand4 < 15) {
                            entry.getKey().complaint();
                            int rand5 = (int) ((Math.random() * (10 - 1)) + 1);
                            if (rand5 < 8) {
                                restaurant.manager.newFood();
                            } else {
                                restaurant.manager.escortClientOut();
                            }
                        }
                        int rand6 = (int) ((Math.random() * (100 - 1)) + 1);
                        if (entry.getKey().hasOrder && rand6 < 15) {
                            entry.getKey().waiter.dropOrder();

                        }
                        int rand7 = (int) ((Math.random() * (10 - 1)) + 1);
                        if (!entry.getKey().hasOrder && rand7 < 9) {
                            entry.getKey().hasOrder = true;
                            restaurant.budgetPerDay += entry.getKey().order();
                        } else {
                            int rand8 = (int) ((Math.random() * (100 - 1)) + 1);
                            if (rand8 < 15 * restaurant.clientList.get(entry.getKey())) {
                                entry.getKey().left();
                                it.remove();
                            } else {
                                restaurant.clientList.put(entry.getKey(), restaurant.clientList.get(entry.getKey()) + 1);
                            }
                        }
                    }
                    int rand9 = (int) ((Math.random() * (2 - 1)) + 1);
                    for (int i = 0; i < Math.min(rand9, restaurant.restaurantCapacity - restaurant.clientList.size()); i++) {
                        restaurant.clientList.put(new Client(names.get(rand), clientNumber, restaurant.getAvailableWaiter().get(), bar, european, sushi), 0);
                        clientNumber++;
                    }
                    System.out.println("Clients in the restaurant: " + restaurant.clientList.size());


                } while (time.isBefore(LocalTime.parse("20:01")));
                System.out.println("The last clients left");
                restaurant.manager.closeRestaurant();
            }
        }
        int profit = restaurant.budgetPerDay - restaurant.wageBill;
        int profitMonth = +profit;
        System.out.println("Profit for the day: " + profit);
        int i = +1;
        if (i % 30 == 0) {
            System.out.println("Profit for the Month: " + profitMonth);
        }
        //}
    }
}
