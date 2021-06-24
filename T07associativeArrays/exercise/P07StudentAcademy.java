package T07associativeArrays.exercise;

import java.util.*;

public class P07StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pairs = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> students = new LinkedHashMap<>();
        Map<String, Double> register = new LinkedHashMap<>();
        for (int i = 0; i < pairs; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            double sumGrade = 0;
            for (Double grade : entry.getValue()) {
                sumGrade += grade;
            }
            if (sumGrade / entry.getValue().size() >= 4.50) {
                register.put(entry.getKey(), sumGrade / entry.getValue().size());
            }
        }
        register.entrySet().stream()
                .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                .forEach(e -> System.out.printf("%s -> %.2f\n", e.getKey(), e.getValue()));

    }
}
