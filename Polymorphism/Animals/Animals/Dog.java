package Animals;

public class Dog extends Animal{
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String getAnimalInfo() {
        return String.format("I am %s and my favourite food is %s\nBARK",super.getName(),super.getFavouriteFood());
    }
}
