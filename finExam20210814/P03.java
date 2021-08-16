package finExam20210814;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //likes<-> comments
        Map<String, int[]> map = new TreeMap<>();
        Map<String, Integer> comments = new TreeMap<>();
        String input = "";

        while (!(input = scan.nextLine()).equals("Log out")) {
            String[] tokens = input.split(":\\s+");
            String userName = tokens[1];
            switch (tokens[0]) {
                case "New follower":
                    map.putIfAbsent(userName, new int[]{0, 0});

                    break;
                case "Like":
                    int count = Integer.parseInt(tokens[2]);
                    map.putIfAbsent(userName, new int[]{0, 0});
                    map.put(userName, new int[]{map.get(userName)[0] + count, map.get(userName)[1]});
                    break;
                case "Comment":
                    map.putIfAbsent(userName, new int[]{0, 0});
                    map.put(userName, new int[]{map.get(userName)[0], map.get(userName)[1] + 1});
                    break;
                case "Blocked":
                    if (!map.containsKey(userName)) {
                        System.out.println(userName + " doesn't exist.");
                    } else {
                        map.remove(userName);
                    }
                    break;
            }
        }
            System.out.println(map.size() + " followers");
            map.entrySet().stream().sorted((f, s) -> {
                int result = Integer.compare(s.getValue()[0] + s.getValue()[1], f.getValue()[0] + f.getValue()[1]);
                if (result == 0) {
                    result = f.getKey().compareTo(s.getKey());
                }
                return result;
            }).forEach(f -> System.out.printf("%s: %d\n", f.getKey(), f.getValue()[0] + f.getValue()[1]));
    }

}
