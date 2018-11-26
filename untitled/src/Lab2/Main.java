package Lab2;

import javax.swing.*;

public class Main {
    public static void main(String [] args)
    {
        Engine engine = new DiselEngine();
        Car car = new Car("My car", engine);
        System.out.println(car);
        car.start();

        Engine engine2 = new PetrolEngine();
        Car car2 = new Car("My car", engine2);
        System.out.println(car2);
        car2.start();
    }
}
