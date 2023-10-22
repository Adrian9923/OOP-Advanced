package BorderControl;

public abstract class Identifier implements Identifiable{
    private String id;

    public Identifier(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
