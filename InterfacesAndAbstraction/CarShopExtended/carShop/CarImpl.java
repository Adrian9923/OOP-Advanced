package carShop;

public abstract class CarImpl implements Car{
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    protected CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This car %s was produced in %s and has %d tires.",this.model,this.countryProduced,TIRES);
    }
}
