package composite;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Drawing drawing = new Drawing();
        drawing.add(circle);
        drawing.draw("red");
    }
}
