package T03arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P10ladyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scan.nextLine());
        int[] initialIndexes = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] field = new int[fieldSize];

        for (int number : initialIndexes) {
            if (number >= 0 && number <= field.length - 1) {
                field[number] = 1;
            }
        }

        String input = "";
        while (!(input = scan.nextLine()).equals("end")) {
            String[] command = input.split(" ");
            int startIndex = Integer.parseInt(command[0]);
            String direction = command[1];
            int distance = Integer.parseInt(command[2]);

            //If we move left -> we deduct indexes
            if (direction.equals("left") && distance != 0) {
                distance = -distance;
            }

            //if the index is outside the field
            boolean isOut = (startIndex < 0) || (startIndex > field.length - 1);
            if (isOut) {
                continue;
            }

            //If there is a ladybug in the start index
            boolean doesExist = field[startIndex] == 1;
            if (!doesExist || distance == 0) {
                continue;
            }

            //The ladybug empties its index
            field[startIndex] = 0;
            //If the new position is out of the field
            int landIndex = startIndex + distance;

            boolean newIsOut = (landIndex < 0) || (landIndex > field.length - 1);
            if (newIsOut) {
                continue;
            }
            //If we have another bug on the new index
            if (field[landIndex] == 1) {
                while (field[landIndex] == 1) {
                    landIndex += distance;
                    if (landIndex < 0 || landIndex > field.length - 1) {
                        break;
                    }
                }
            }
            if (landIndex >= 0 && landIndex <= field.length - 1) {
                field[landIndex] = 1;
            }

        }

        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");
        }
    }
}
