package Farm;

abstract class Animal {
    private String name;
    private double weight;
    private int foodEaten;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public String getName() {
        return name;
    }


    public double getWeight() {
        return weight;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);


}
