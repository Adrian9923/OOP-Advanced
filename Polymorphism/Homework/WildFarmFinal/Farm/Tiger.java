package Farm;

import java.text.DecimalFormat;

public class Tiger extends Feline {

    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");

    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            throw new IllegalArgumentException(("The type of food cannot be consumed by " + this.getClass().getSimpleName()) + "s");
        }else {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }
    }
}
