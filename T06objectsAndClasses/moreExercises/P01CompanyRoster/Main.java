package T06objectsAndClasses.moreExercises.P01CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        List<Employee> employeeList = new ArrayList<>();
        while (lines-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = new Employee(name, salary, position, department);
            if (tokens.length > 4) {
                try {
                    employee.setAge(Integer.parseInt(tokens[4]));
                } catch (Exception e) {
                    employee.setEmail(tokens[4]);
                }
                if (tokens.length > 5) {
                    employee.setAge(Integer.parseInt(tokens[5]));
                }
            }
            employeeList.add(employee);
        }
        //we get a list of all departments
        List<String> departmentsNames = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct().collect(Collectors.toList());
        //we make a list by departments

        List<Department> departments = new ArrayList<>();
        for (String deptName : departmentsNames) {
            departments.add(new Department(deptName,
                    employeeList.stream().filter(e -> e.getDepartment().equals(deptName))
                            .collect(Collectors.toList())));
        }
        departments = departments.stream().sorted(Comparator.comparingDouble(Department::getAvgSalary)
                .reversed()).collect(Collectors.toList());

        Department bestDept = departments.get(0);
        System.out.printf("Highest Average Salary: %s\n", bestDept.getDeptName());
        bestDept.getEmployees().stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
    }
}
