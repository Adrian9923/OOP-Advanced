package Animals;

public class Cat extends Animal{


    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String getAnimalInfo() {
        return String.format("%s\nMEOW",super.toString());
    }
}
