package T06objectsAndClasses.exercise.P07OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        List<Person> people = new ArrayList<>();
        while (!(input = scan.nextLine()).equals("End")) {
            String name = input.split("\\s+")[0];
            String ID = input.split("\\s+")[1];
            int age = Integer.parseInt(input.split("\\s+")[2]);
            Person person = new Person(name, ID, age);
            people.add(person);
        }
        people.sort(Comparator.comparing(Person::getAge));
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
