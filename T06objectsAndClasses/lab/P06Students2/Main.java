package T06objectsAndClasses.lab.P06Students2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        List<T06objectsAndClasses.lab.P06Students2.Students> studentsList = new ArrayList<>();
        while (!input.equals("end")) {
            String[] studentData = input.split(" ");
            String firstName = studentData[0];
            String lastName = studentData[1];
            int age = Integer.parseInt(studentData[2]);
            String city = studentData[3];

            if (!doesStudentExist(studentsList, firstName, lastName)) {
                Students student = new Students(firstName, lastName, age, city);
                studentsList.add(student);
            }
            if (doesStudentExist(studentsList, firstName, lastName)) {
                Students student = getStudent(studentsList, firstName, lastName);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHometown(city);
            }

            input = scan.nextLine();
        }

        String filterCity = scan.nextLine();
        for (Students student : studentsList) {
            if (student.getHometown().equals(filterCity)) {
                System.out.printf("%s %s is %d years old\n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    private static Students getStudent(List<Students> studentsList, String firstName, String lastName) {
        Students existingStudent = null;
        for (Students student : studentsList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        } return existingStudent;
    }


    private static boolean doesStudentExist(List<Students> students, String firstName, String lastName) {
        for (Students student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
}
