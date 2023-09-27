package template;

// Here we have a main prepareSalad() method that calls our four methods.
//
//They contain the "algorithm" to make a salad.

public class Salad {

    void prepareSalad() {
        peelVeggies();
        addCheese();
        addFlavour();
        addDressing();
    }

    public void peelVeggies() {
        System.out.println("Peeling Oranges");
    }

    public void addCheese() {
        System.out.println("Adding Cheese");
    }

    public void addFlavour() {
        System.out.println("Spice with some flavour");
    }

    public void addDressing() {
        System.out.println("Adding Dressing");
    }

}
