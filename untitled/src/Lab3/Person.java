package Lab3;

public class Person {
    private String name;
    private int age;
    private int Cnp;

    public Person(String name, int age, int cnp) {
        this.name = name;
        this.age = age;
        this.Cnp = cnp;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Cnp=" + Cnp +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCnp() {
        return Cnp;
    }

    public void setCnp(int cnp) {
        Cnp = cnp;
    }
}
