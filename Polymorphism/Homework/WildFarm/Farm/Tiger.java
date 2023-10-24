package Farm;

import java.text.DecimalFormat;

class Tiger extends Feline {

    public Tiger(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("The type of food cannot be consumed by Tigers");
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
