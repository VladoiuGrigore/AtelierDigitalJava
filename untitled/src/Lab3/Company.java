package Lab3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Company {
    private String name;
    private HashMap<Integer,Employee> employees = new HashMap<Integer, Employee>();

    public Company(String name) {
        this.name = name;
    }

    public void addEmployee(Employee e)
    {
        employees.put(e.getCnp(),e);
    }

    public Employee getEmployeeByCnp(int cnp)
    {
        return employees.get(cnp);
    }
    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
    public float getSalaryByCnp(int cnp)
    {
        float salary=0;

        Employee emp = getEmployeeByCnp(cnp);
        List<Float> hours = emp.getRecordingHours();
        float hourSalary = emp.getHourSalary();

        Iterator<Float> iterator = hours.iterator();
        while(iterator.hasNext())
        {
            salary+=iterator.next();
        }


        return salary * hourSalary;
    }
}
