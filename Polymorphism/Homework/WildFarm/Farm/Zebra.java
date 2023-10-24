package Farm;

import java.text.DecimalFormat;

class Zebra extends Mammal {

    public Zebra(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.#");
        return String.format("%s[%s, %s, %s, %d]",
                this.getClass().getSimpleName(), super.getName(), format.format(super.getWeight()),
                super.getLivingRegion(), super.getFoodEaten());
    }
}
