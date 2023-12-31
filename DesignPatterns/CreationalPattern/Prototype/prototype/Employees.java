package prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{
    private final List<String> repository;

    public Employees() {
        this.repository = new ArrayList<>();
    }

    public Employees(List<String> repository) {
        this.repository = repository;
    }

    public void loadData() {
        this.repository.add("John");
        this.repository.add("Alex");
        this.repository.add("Lisa");
    }

    public List<String> getRepository() {
        return this.repository;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>(this.getRepository());
        return new Employees(temp);
    }
}
