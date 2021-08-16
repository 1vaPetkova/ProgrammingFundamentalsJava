package finalExamPrep.archive;

import java.util.*;
import java.util.stream.Collectors;

public class P03EnduranceRally {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split(" ");
        Map<String, Double> participants = new LinkedHashMap<>();
        for (int i = 0; i < names.length; i++) {
            participants.put(names[i], (double) ((int) names[i].charAt(0)));
        }


        List<Double> zones = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        List<Integer> checkpoints = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Map.Entry<String, Double> entry : participants.entrySet()) {
            int lastZone = 0;
            boolean cantFinish = false;
            for (int i = 0; i < zones.size(); i++) {
                if (checkpoints.contains(i)) {
                    entry.setValue(entry.getValue() + zones.get(i));
                } else {
                    entry.setValue(entry.getValue() - zones.get(i));
                    if (entry.getValue() <= 0) {
                        cantFinish = true;
                        lastZone = i;
                        break;
                    }
                }
            }
            if (cantFinish) {
                System.out.printf("%s - reached %d\n", entry.getKey(), lastZone);
            } else {
                System.out.printf("%s - fuel left %.2f\n", entry.getKey(), entry.getValue());
            }
        }


    }
}
