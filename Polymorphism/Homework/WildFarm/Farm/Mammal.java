package Farm;

abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String name, double weight) {
        super(name, weight);
    }

    public Mammal(String name, double weight, String livingRegion) {
        super(name, weight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}
