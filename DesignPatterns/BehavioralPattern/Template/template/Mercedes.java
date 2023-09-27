package template;

public class Mercedes extends CarTemplate{


    @Override
    public void addModel() {
        System.out.println("A-Class");
    }

    @Override
    public void addBrand() {
        System.out.println("Mercedes");
    }
}
