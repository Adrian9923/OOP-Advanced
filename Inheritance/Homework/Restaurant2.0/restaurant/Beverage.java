package restaurant;

import java.math.BigDecimal;

public class Beverage extends Product{
    private double millimeters;

    public Beverage(String name, BigDecimal price, double millimeters) {
        super(name, price);
        this.millimeters = millimeters;
    }

    public double getMillimeters() {
        return millimeters;
    }
}
