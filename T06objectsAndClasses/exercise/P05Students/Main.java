package T06objectsAndClasses.exercise.P05Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] studentsData = scan.nextLine().split("\\s+");
            String firstName = studentsData[0];
            String lastName = studentsData[1];
            double grade = Double.parseDouble(studentsData[2]);
            Student currentStudent = new Student(firstName, lastName, grade);
            students.add(currentStudent);
        }
        List<Student> sortedList = students.stream()
                        .sorted(Comparator.comparing(Student::getGrade)
                        .reversed()).collect(Collectors.toList());
        for (Student student : sortedList) {
            System.out.println(student);
        }
    }
}
