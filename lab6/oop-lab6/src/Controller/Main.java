package Controller;

public class Main {
    public static void main(String[] args) {
        Probability probability = new Probability(0.9,0.1);
        Simulation simulation = new Simulation(probability);
        simulation.simulate();

    }
}

