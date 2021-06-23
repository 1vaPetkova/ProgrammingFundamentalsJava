package finalExamPrep.fin05;

import java.util.Locale;
import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine();
        String input = "";
        while (!(input = scan.nextLine()).equals("Generate")) {
            switch (input.split(">>>")[0]) {
                case "Contains":
                    String substring = input.split(">>>")[1];
                    if (key.contains(substring)) {
                        System.out.printf("%s contains %s\n", key, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String flipper = input.split(">>>")[1];
                    int startIndex = Integer.parseInt(input.split(">>>")[2]);
                    int endIndex = Integer.parseInt(input.split(">>>")[3]);
                    if (flipper.equals("Lower")) {
                        key = key.replace(key.substring(startIndex, endIndex),
                                key.substring(startIndex, endIndex).toLowerCase());
                    } else {
                        key = key.replace(key.substring(startIndex, endIndex),
                                key.substring(startIndex, endIndex).toUpperCase());
                    }
                    System.out.println(key);
                    break;
                case "Slice":
                    int start = Integer.parseInt(input.split(">>>")[1]);
                    int end = Integer.parseInt(input.split(">>>")[2]);
                    key = key.replace(key.substring(start, end), "");
                    System.out.println(key);
                    break;
            }
        }
        System.out.println("Your activation key is: " + key);
    }

}
