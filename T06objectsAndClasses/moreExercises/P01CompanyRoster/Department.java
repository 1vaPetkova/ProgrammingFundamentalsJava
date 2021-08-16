package T06objectsAndClasses.moreExercises.P01CompanyRoster;
import java.util.List;

public class Department {
    private String deptName;
    private List<Employee> employees;
    private double avgSalary;

    public Department(String deptName, List<Employee> employeeList) {
        this.deptName = deptName;
        this.employees = employeeList;
        this.avgSalary = this.employees
                .stream()
                .mapToDouble(Employee::getSalary)
                .average().orElse(0.00);
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public String getDeptName() {
        return deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
