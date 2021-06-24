package T06objectsAndClasses.moreExercises.P01CompanyRoster_NF;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String email = "n/a";
            int age = -1;
            String[] input = scan.nextLine().split(" ");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            if (input.length > 4) {
                email = input[4];
            }
            if (input.length > 5) {
                age = Integer.parseInt(input[5]);
            }
            Employee employee = new Employee(name, salary, position, department, email, age);
            employees.add(employee);
        }
        List<String> departmentNames = employees.stream()
                .map(Employee::getDepartment)
                .distinct().collect(Collectors.toList());
        List<Department> departments = new ArrayList<>();
        for (String department : departmentNames) {
            departments.add(new Department(department,
                    employees.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList())));
        }
        departments.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());
        Department department = departments.get(0);
        department.getEmployees().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s\n", department.getName());
        for (Employee employee : department.getEmployees()) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }
}

