import java.io.Serializable;
import java.util.Objects;

public class Person extends Human implements Serializable {
    public String lastName;
    private String firstName = "Igor";
    public int age;
    private int height;

    public Person(String lastName, String firstName, int age, int height) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.height = height;
    }

    public Person(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        if (getHeight() != person.getHeight()) return false;
        if (getLastName() != null ? !getLastName().equals(person.getLastName()) : person.getLastName() != null)
            return false;
        return getFirstName() != null ? getFirstName().equals(person.getFirstName()) : person.getFirstName() == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, age, height);
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
