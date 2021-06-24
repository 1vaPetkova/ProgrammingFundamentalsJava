package T07associativeArrays.moreExercise;

import java.util.*;

public class P01Ranking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = "";
        Map<String, String> contestValidation = new LinkedHashMap<>();
        while (!(input1 = scan.nextLine()).equals("end of contests")) {
            String contestName = input1.split(":")[0];
            String contestPassword = input1.split(":")[1];
            contestValidation.putIfAbsent(contestName, contestPassword);
        }

        String input2 = "";
        Map<String, Map<String, Integer>> users = new TreeMap<>();
        while (!(input2 = scan.nextLine()).equals("end of submissions")) {
            String currContest = input2.split("=>")[0];
            String currPassword = input2.split("=>")[1];
            String currUser = input2.split("=>")[2];
            int points = Integer.parseInt(input2.split("=>")[3]);
            if (contestValidation.containsKey(currContest)
                    && contestValidation.get(currContest).equals(currPassword)) {
                users.putIfAbsent(currUser, new TreeMap<>());
                users.get(currUser).putIfAbsent(currContest, 0);
                users.get(currUser).put(currContest, Math.max(users.get(currUser).get(currContest), points));
            }
        }
        String bestCandidate = "";
        int maxPoints = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : users.entrySet()) {
            int currentSum = 0;
            for (Map.Entry<String, Integer> points : entry.getValue().entrySet()) {
                currentSum += points.getValue();
            }
            if (currentSum > maxPoints) {
                maxPoints = currentSum;
                bestCandidate = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.\n", bestCandidate, maxPoints);
        System.out.println("Ranking: ");
        users.forEach((k, v) -> {
            System.out.println(k);
            v.entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                    .forEach(e -> System.out.println("#  " + e.getKey() + " -> " + e.getValue()));
        });
    }
}
