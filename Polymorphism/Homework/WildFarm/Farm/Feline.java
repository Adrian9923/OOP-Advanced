package Farm;

abstract class Feline extends Mammal {

    public Feline(String name, double weight) {
        super(name, weight);
    }

    public Feline(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }
}
