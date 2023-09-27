package composite;

import java.util.ArrayList;
import java.util.List;

// The composite Object
public class Drawing implements Shape{
    private List<Shape> shapes;

    public Drawing() {
        this.shapes = new ArrayList<>();
    }

    public void add(Shape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void draw(String color) {
        for (Shape shape : this.shapes) {
            shape.draw(color);
        }

    }
}
