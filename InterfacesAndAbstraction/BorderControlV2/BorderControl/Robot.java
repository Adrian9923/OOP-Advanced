package BorderControl;

public class Robot extends Identifier{
    private String model;

    public Robot(String id, String model) {
        super(id);
        this.model = model;
    }


    public String getModel() {
        return model;
    }


}
