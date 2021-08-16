package finalExamPrep.extra;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04HornetArmadav2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        //legionName - lastActivity
        Map<String, Long> activities = new LinkedHashMap<>();
        //legionName - soldier Type - soldier count
        Map<String, Map<String, Long>> soldiers = new LinkedHashMap<>();
        Pattern regex = Pattern.compile("([0-9]+) = ([^=\\-\\>: ]+) -> ([^=\\-\\>: ]+):([0-9]+)");
        while (lines-- > 0) {
            Matcher m = regex.matcher(scan.nextLine());

            String legionName = "";
            String soldierType = "";
            long lastActivity = 0;
            long soldierCount = 0L;

            while (m.find()) {
                lastActivity = Integer.parseInt(m.group(1));
                legionName = m.group(2);
                soldierType = m.group(3);
                soldierCount = Long.parseLong(m.group(4));
            }

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