package T07associativeArrays.archive;

import java.util.*;

public class P06UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Map<String, Map<String, Integer>> map = new TreeMap<>();
        List<String> list = new ArrayList<>();
        while (!(input = scan.nextLine()).equals("end")) {
            String partIP = input.split(" ")[0];
            String ip = partIP.substring(3, partIP.length());
            String partMessage = input.split(" ")[1];
            String message = partMessage.substring(9, partMessage.length() - 1);
            String partUser = input.split(" ")[2];
            String user = partUser.substring(5);
            map.putIfAbsent(user, new LinkedHashMap<>());
            map.get(user).putIfAbsent(ip, 0);
                map.get(user).put(ip, map.get(user).get(ip) + 1);
        }
        map.entrySet().stream().forEach(e -> {
        StringBuilder newBuilder = new StringBuilder();
            System.out.println(e.getKey() + ":");
            e.getValue().entrySet().stream()
                    .forEach(ip -> {
                        newBuilder.append(String.format("%s => %d, ", ip.getKey(), ip.getValue()));
                    });
            System.out.println(newBuilder.toString()
                    .substring(0, newBuilder.toString().length() - 2) + ".");
        });
    }
}
