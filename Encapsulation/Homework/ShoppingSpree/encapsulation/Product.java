package encapsulation;

public class Product {
    private String productName;
    private double cost;

    public Product(String name, double cost) {
        this.setProductName(name);
        this.setCost(cost);
    }

    private void setProductName(String productName) {
        if (productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.productName = productName;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public double getCost() {
        return cost;
    }
}
