package finalExamPrep.fin02v2;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder stops = new StringBuilder(scan.nextLine());
        String input = "";
        while (!(input = scan.nextLine()).equals("Travel")) {
            String[] commands = input.split(":");
            switch (commands[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(commands[1]);
                    String str = commands[2];
                    if (isInBounds(index, stops.toString())) {
                        stops.insert(index, str);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    if (isInBounds(startIndex, stops.toString()) && isInBounds(endIndex, stops.toString())) {
                        stops.delete(startIndex, endIndex + 1);
                    }
                    break;
                case "Switch":
                    String oldString = commands[1];
                    String newString = commands[2];
                    if (stops.toString().contains(oldString)) {
                        stops = new StringBuilder(stops.toString().replace(oldString, newString));
                    }
                    break;
            }
            System.out.println(stops);
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }

    private static boolean isInBounds(int index, String stops) {
        return index >= 0 && index < stops.length();
    }
}
