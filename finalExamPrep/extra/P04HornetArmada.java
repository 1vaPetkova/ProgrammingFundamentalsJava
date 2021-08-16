package finalExamPrep.extra;

import java.util.*;

public class P04HornetArmada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        //legionName - lastActivity
        Map<String, Long> activities = new LinkedHashMap<>();
        //legionName - soldier Type - soldier count
        Map<String, Map<String, Long>> soldiers = new LinkedHashMap<>();
        while (lines-- > 0) {
            String[] txt = scan.nextLine().replaceAll(" ", "").split("=");
            long lastActivity = Long.parseLong(txt[0]);

            String legionName = txt[1].split("->")[0];
            String soldierType =txt[1].split("->")[1].split(":")[0];
            long soldierCount = Long.parseLong(txt[1].split("->")[1].split(":")[1]);

            activities.putIfAbsent(legionName, 0L);
            activities.put(legionName, Math.max(lastActivity, activities.get(legionName)));
            soldiers.putIfAbsent(legionName, new LinkedHashMap<>());
            soldiers.get(legionName).putIfAbsent(soldierType, 0L);
            soldiers.get(legionName)
                    .put(soldierType, soldiers.get(legionName).get(soldierType) + soldierCount);
        }
        String[] input = scan.nextLine().split("\\\\");
        if (input.length > 1) {
            long activity = Long.parseLong(input[0]);
            String soldierType = input[1];

            soldiers.entrySet().stream().filter(l -> l.getValue().containsKey(soldierType))
                    .sorted((a, b) -> Long.compare(b.getValue().get(soldierType), a.getValue().get(soldierType)))
                    .forEach(l -> {
                        if (activities.get(l.getKey()) < activity) {
                            System.out.printf("%s -> %d\n", l.getKey(), l.getValue().get(soldierType));
                        }
                    });
        } else {
            String soldierType = input[0];

            activities.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .forEach(a -> {
                        if (soldiers.get(a.getKey()).containsKey(soldierType)) {
                            System.out.println(a.getValue() + " : " + a.getKey());
                        }
                    });
        }
    }
}
