package T07associativeArrays.exercise;

import java.util.*;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Map<String, List<String>> register = new LinkedHashMap<>();
        while (!(input = scan.nextLine()).equals("end")) {
            String course = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];
            register.putIfAbsent(course, new ArrayList<>());
            register.get(course).add(studentName);
        }
        register.entrySet().stream()
                .sorted((f, s) -> Integer.compare(s.getValue().size(), f.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(student -> System.out.println("-- " + student));
                });
    }
}
