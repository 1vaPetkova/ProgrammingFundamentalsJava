package midExamPrep.mid01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGamev2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = "";
        int moves = 0;
        boolean isOver = false;
        while (!(input = scan.nextLine()).equals("end")) {
            moves++;
            int firstIndex = Integer.parseInt(input.split("\\s+")[0]);
            int secondIndex = Integer.parseInt(input.split("\\s+")[1]);
            if (firstIndex == secondIndex || isNotValid(firstIndex, list) || isNotValid(secondIndex, list)) {
                list.add(list.size() / 2, String.format("-%da", moves));
                list.add(list.size() / 2, String.format("-%da", moves));
                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (list.get(firstIndex).equals(list.get(secondIndex))) {
                System.out.printf("Congrats! You have found matching elements - %s!\n", list.get(firstIndex));
                String elementToRemove = list.get(firstIndex);
                list.remove(elementToRemove);
                list.remove(elementToRemove);
            } else {
                System.out.println("Try again!");
            }
            if (list.isEmpty()) {
                System.out.printf("You have won in %d turns!\n", moves);
                isOver = true;
                break;
            }
        }
        if (!isOver) {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", list));
        }
    }

    private static boolean isNotValid(int index, List<String> list) {
        return index < 0 || index >= list.size();
    }
}
