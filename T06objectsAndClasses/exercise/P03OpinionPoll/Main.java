package T06objectsAndClasses.exercise.P03OpinionPoll;


import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        List<Person> peopleList = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String[] personalInfo = scan.nextLine().split("\\s+");
            String name = personalInfo[0];
            int age = Integer.parseInt(personalInfo[1]);
            if (age > 30) {
                Person person = new Person(name, age);
                peopleList.add(person);
            }
        }
        peopleList.sort(Comparator.comparing(Person::getName));
        for (Person person : peopleList) {
            System.out.println(person);
        }
    }
}
