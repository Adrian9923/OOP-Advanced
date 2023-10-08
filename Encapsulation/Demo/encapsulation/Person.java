package encapsulation;

public class Person {
    public String firstName;
    public String lastName;
    public int age;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = 0;
    }

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName);
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        if (this.getAge() == 0) {
            return String.format("%s %s",this.getFirstName(), this.getLastName());
        }
        return String.format("%s %s is %d",this.getFirstName(),this.getLastName(),this.getAge());
    }
}
