package T07associativeArrays.archive;

import java.util.*;

public class P08LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> map = new TreeMap<>();
        Map<String, Integer> time = new TreeMap<>();

        for (int i = 0; i < lines; i++) {
            String input = scan.nextLine();
            String ip = input.split(" ")[0];
            String user = input.split(" ")[1];
            int duration = Integer.parseInt(input.split(" ")[2]);
            map.putIfAbsent(user, new ArrayList<>());
            if (!map.get(user).contains(ip)) {
                map.get(user).add(ip);
            }
            time.putIfAbsent(user, 0);
            time.put(user, time.get(user) + duration);
        }
        for (Map.Entry<String, List<String>> lists : map.entrySet()) {
            Collections.sort(lists.getValue());
        }

        time.entrySet().stream().forEach(entry-> {
                    System.out.print(entry.getKey() + ": " + entry.getValue() + " ");
                    System.out.println(map.get(entry.getKey()));
        });
    }
}

