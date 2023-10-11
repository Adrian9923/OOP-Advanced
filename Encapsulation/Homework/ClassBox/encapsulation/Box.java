package encapsulation;

public class Box {
    private double length;
    private double width;
    private double height;


    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    public double calculateSurface() {
        return (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.height * this.width);
    }

    public double calculateLateralSurface() {
        return 2 * this.height * (this.length + this.width);
    }

    @Override
    public String toString() {
        return String.format("Surface - %.2f\nLateral Surface - %.2f\nVolume - %.2f",this.calculateSurface(), this.calculateLateralSurface(), this.calculateVolume());
    }
}
