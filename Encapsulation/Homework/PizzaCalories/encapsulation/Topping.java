package encapsulation;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        if (!(toppingType.equals("Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese")|| toppingType.equals("Sauce"))) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    public String getToppingType() {
        return toppingType;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(getToppingType() + " weight should be in the range (1..50)");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = this.weight * 2;
        switch (this.toppingType) {
            case "Meat":
                calories *= 1.2;
                break;
            case "Veggies":
                calories *= 0.8;
                break;
            case "Cheese":
                calories *= 1.1;
                break;
            case "Sauce":
                calories *= 0.9;
                break;
        }
        return calories;
    }
}
