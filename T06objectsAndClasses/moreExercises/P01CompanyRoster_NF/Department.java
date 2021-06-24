package T06objectsAndClasses.moreExercises.P01CompanyRoster_NF;

import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;
    private double avgSalary;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
        this.avgSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAvgSalary() {
        return avgSalary;
    }
}
