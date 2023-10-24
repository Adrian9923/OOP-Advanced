package Farm;

import java.text.DecimalFormat;

public class Mouse extends Mammal {
    public Mouse( String animalName, Double animalWeight,String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException(("The type of food cannot be consumed by " + this.getClass().getSimpleName()) + "s");
        }else {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }
    }
}
