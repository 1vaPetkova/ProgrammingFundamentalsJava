package T03arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P10ladyBugsv2 {
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
            int index = Integer.parseInt(command[0]);
            String direction = command[1];
            int distance = Integer.parseInt(command[2]);

            //We check before flying
            if (index >= 0 && index < field.length && field[index] == 1) {

                //We start flying
                field[index] = 0;

                //Moving right
                if (direction.equals("right")) {
                    index += distance;
                    while (index >= 0 && index <= field.length - 1 && field[index] == 1) {
                        index += distance;
                    }
                    if (index >= 0 && index <= field.length - 1) {
                        field[index] = 1;
                    }
                    //Moving left
                } else if (direction.equals("left")) {
                    index -= distance;
                    while (index >= 0 && index <= field.length - 1 && field[index] == 1) {
                        index -= distance;
                    }
                    if (index >= 0 && index <= field.length - 1) {
                        field[index] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");
        }
    }
}

