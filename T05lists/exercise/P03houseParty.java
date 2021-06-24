package T05lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03houseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());
        List<String> guests = new ArrayList<>();
        for (int i = 0; i < inputs; i++) {
            List<String> command = Arrays.stream(scan.nextLine().split(" "))
                    .collect(Collectors.toList());
            boolean isInTheList = guests.contains(command.get(0));
            if (command.get(2).equals("going!")) {
                if (isInTheList) {
                    System.out.printf("%s is already in the list!\n", command.get(0));
                } else {
                    guests.add(command.get(0));
                }
            } else {
                if (isInTheList) {
                    guests.remove(command.get(0));
                } else {
                    System.out.printf("%s is not in the list!\n", command.get(0));
                }
            }
        }
        for (String name : guests) {
            System.out.println(name);
        }
    }
}
