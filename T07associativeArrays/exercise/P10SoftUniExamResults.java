package T07associativeArrays.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //username -> points
        Map<String, Integer> userPoints = new HashMap<>();
        //language -> submissions
        Map<String, Integer> submissions = new HashMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("exam finished")) {
            String[] tokens = input.split("-");
            String username = tokens[0];
            if (tokens.length > 2) {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                userPoints.putIfAbsent(username, 0);
                userPoints.put(username, Math.max(userPoints.get(username), points));

                submissions.putIfAbsent(language, 0);
                submissions.put(language, submissions.get(language) + 1);
            } else {
                userPoints.remove(username);
            }
        }
        System.out.println("Results:");
        userPoints.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));
        System.out.println("Submissions:");
        submissions.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
