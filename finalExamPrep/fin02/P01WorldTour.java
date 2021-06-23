package finalExamPrep.fin02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destinations = scan.nextLine();
        String input = "";
        while (!(input = scan.nextLine()).equals("Travel")) {
            switch (input.split(":")[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(input.split(":")[1]);
                    String string = input.split(":")[2];
                    StringBuilder addedStop = new StringBuilder(destinations);
                    if (index >= 0 && index < destinations.length()) {
                        addedStop.insert(index,string);
                    }
                    destinations = addedStop.toString();
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(input.split(":")[1]);
                    int endIndex = Integer.parseInt(input.split(":")[2]);
                    StringBuilder removedStop = new StringBuilder(destinations);
                    if (startIndex >= 0 && startIndex < destinations.length()
                            && endIndex >=0 && endIndex < destinations.length()) {
                        removedStop.delete(startIndex, endIndex + 1);
                    }
                    destinations = removedStop.toString();
                    break;
                case "Switch":
                    String oldString = input.split(":")[1];
                    String newString = input.split(":")[2];
                    if (destinations.contains(oldString)) {
                        destinations = destinations.replace(oldString, newString);
                    }
                    break;
            }
            System.out.println(destinations);
        }
        System.out.println("Ready for world tour! Planned stops: " + destinations);
    }
}
