package Lab2;

public class Car {
    private String name;
    private Engine engine;

    public Car(String nume, Engine engine)
    {
        this.name = name;
        this.engine = engine;
    }
    public boolean start()
    {
        boolean b = engine.start();
        System.out.println("Turn on the lights");
        return b;
    }
    public String toString()
    {
        return name+"\n\t" + engine;
    }
}
