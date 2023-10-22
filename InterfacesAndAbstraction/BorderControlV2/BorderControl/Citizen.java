package BorderControl;

public class Citizen extends Identifier{
   private String name;
   private int age;

    public Citizen(String name, int age, String id) {
        super(id);
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


}
