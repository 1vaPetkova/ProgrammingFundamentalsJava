package T07associativeArrays.archive;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05ParkingValidation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern plateP = Pattern.compile("[A-Z]{2}[0-9]{4}[A-Z]{2}");
        int lines = Integer.parseInt(scan.nextLine());
        Map<String, String> cars = new LinkedHashMap<>();
        while (lines-- > 0) {
            String[] info = scan.nextLine().split("\\s+");
            String userName = info[1];

            switch (info[0]) {
                case "register":
                    Matcher plateM = plateP.matcher(info[2]);
                    if (!plateM.find()) {
                        System.out.println("ERROR: invalid license plate " + info[2]);
                    } else {
                        String plateNumber = plateM.group();
                        if (cars.entrySet().stream()
                                .anyMatch(e -> e.getKey().equals(userName) && !e.getValue().equals(plateNumber))) {
                            System.out.println("ERROR: already registered with plate number " + cars.get(userName));
                        } else if (cars.entrySet().stream().anyMatch(e -> e.getValue().equals(plateNumber))) {
                            System.out.printf("ERROR: license plate %s is busy\n", plateNumber);
                        } else {
                            cars.put(userName, plateNumber);
                            System.out.printf("%s registered %s successfully\n", userName, plateNumber);
                        }
                    }
                    break;
                case "unregister":
                    if (!cars.containsKey(userName)) {
                        System.out.printf("ERROR: user %s not found\n", userName);
                    } else {
                        cars.remove(userName);
                        System.out.printf("user %s unregistered successfully\n", userName);
                    }
                    break;
            }
        }
        cars.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
