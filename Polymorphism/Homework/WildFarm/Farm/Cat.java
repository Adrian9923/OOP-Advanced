package Farm;

import java.text.DecimalFormat;

class Cat extends Feline {
    private String breed;

    public Cat(String name, double weight,String livingRegion, String breed) {
        super(name, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }


    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.#");
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getClass().getSimpleName(), super.getName(), this.breed, format.format(super.getWeight()),
                super.getLivingRegion(), super.getFoodEaten());
    }
}
