package composite;
// This is the Leaf

public class Circle implements Shape{
    @Override
    public void draw(String color) {
        System.out.println("Let us draw a " + color + " circle.");
    }
}
