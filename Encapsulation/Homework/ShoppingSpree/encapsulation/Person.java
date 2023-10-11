package encapsulation;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    private int productsCount() {
        return this.products.size();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            System.out.printf("%s can't afford %s\n",this.name,product.getProductName());
        }else {
            System.out.printf("%s bought %s\n",this.getName(),product.getProductName());
            this.products.add(product);
            this.money -= product.getCost();
        }
    }

    @Override
    public String toString() {
        if (productsCount() == 0) {
            return String.format("%s - Nothing bought\n",this.name);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - ", this.name));
        int counter = 0;
        for (Product product : this.products) {
            if (counter == this.products.size() - 1){
                sb.append(String.format("%s", product.getProductName()));
            }else
            sb.append(String.format("%s, ", product.getProductName()));
            counter++;
        }
        return sb.toString();
    }
}
