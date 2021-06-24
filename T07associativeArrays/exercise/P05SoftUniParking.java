package T07associativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        Map<String, String> register = new LinkedHashMap<>();
        for (int i = 0; i < lines; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String username = tokens[1];
            switch (tokens[0]) {
                case "register":
                    String plateNumber = tokens[2];
                    if (!register.containsKey(username)) {
                        register.put(username, plateNumber);
                        System.out.printf("%s registered %s successfully\n", username, register.get(username));
                    } else {
                        System.out.println("ERROR: already registered with plate number " + register.get(username));
                    }
                    break;
                case "unregister":
                    if (!register.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found\n", username);
                    } else {
                        System.out.printf("%s unregistered successfully\n", username);
                        register.remove(username);
                    }
                    break;
            }
        }
        register.forEach((k, v) -> System.out.printf("%s => %s\n", k, v));
    }
}
