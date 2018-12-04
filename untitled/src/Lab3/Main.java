package Lab3;

public class Main {
    public static void main(String[] args)
    {
        Employee emp = new Employee("Steve",25,123,"Dev", "Developer",20);
        System.out.println(emp);
        Employee emp2 = new Employee("Steve2",26,1234,"Dev2", "Developer2",22);
        emp.addHour(4);
        emp.addHour(2);
        System.out.println(emp);

        Company c = new Company("Google");
        c.addEmployee(emp);
        c.addEmployee(emp2);
        System.out.println("\n\n"+c.getEmployeeByCnp(1234));
        int cnp = 123;
        System.out.println("Salary for: \n\t" + c.getEmployeeByCnp(cnp)+"\n is"+ c.getSalaryByCnp(cnp));
    }
}
