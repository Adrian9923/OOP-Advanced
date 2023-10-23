package Animals;

public class Dog extends Animal{
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String getAnimalInfo() {
        return String.format("%s\nBARK",super.toString());
    }
}
