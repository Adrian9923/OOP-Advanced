package builder;


public class Laptop {
    // 2 fields will be optional, 2 required

    // required
    private String brand;
    private String model;

    // optional
    private double SSD;
    private double RAM;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getSSD() {
        return SSD;
    }

    public double getRAM() {
        return RAM;
    }

    Laptop(LaptopBuilder laptopBuilder) {
        this.brand = laptopBuilder.getBrand();
        this.model = laptopBuilder.getModel();
        this.RAM = laptopBuilder.getRAM();
        this.SSD = laptopBuilder.getSSD();
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", SSD=" + SSD +
                ", RAM=" + RAM +
                '}';
    }
}
