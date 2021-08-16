package finalExamPrep.fin05v2;

import java.util.Locale;
import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder key = new StringBuilder(scan.nextLine());
        String input = "";
        while (!(input = scan.nextLine()).equals("Generate")) {
            String[] commands = input.split(">>>");
            switch (commands[0]) {
                case "Contains":
                    String substr = commands[1];
                    if (key.toString().contains(substr)) {
                        System.out.println(key + " contains " + substr);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(commands[2]);
                    int endIndex = Integer.parseInt(commands[3]);
                    String substringToChange = key.substring(startIndex, endIndex);
                    if (commands[1].equals("Upper")) {
                        key = new StringBuilder(key.toString()
                                .replace(substringToChange, substringToChange.toUpperCase()));
                    } else if (commands[1].equals("Lower")) {
                        key = new StringBuilder(key.toString()
                                .replace(substringToChange, substringToChange.toLowerCase()));
                    }
                    System.out.println(key);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(commands[1]);
                    endIndex = Integer.parseInt(commands[2]);
                    key.delete(startIndex, endIndex);
                    System.out.println(key);
                    break;
            }
        }
        System.out.println("Your activation key is: " + key);
    }
}
