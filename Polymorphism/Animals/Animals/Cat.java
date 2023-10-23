package Animals;

public class Cat extends Animal{


    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String getAnimalInfo() {
        return String.format("I am %s and my favourite food is %s\nMEOW",super.getName(),super.getFavouriteFood());
    }
}
