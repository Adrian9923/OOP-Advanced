package encapsulation;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("A chicken's name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("A chicken's age can only be a number between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay() {
        if (this.age < 6){
            return 2;
        }else if (this.age < 12) {
            return 1;
        }else
            return 0.75;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s (%d) can lay %.2f eggs per day.",this.getName(), this.getAge(), this.productPerDay());
    }
}
