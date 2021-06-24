package midExamPrep.mid01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());
        String input = "";
        int countMoves = 0;
        while (!(input = scan.nextLine()).equals("end")) {
            String[] token = input.split(" ");
            int firstIndex = Integer.parseInt(token[0]);
            int secondIndex = Integer.parseInt(token[1]);
            int maxIndex = Math.max(firstIndex, secondIndex);
            int minIndex = Math.min(firstIndex, secondIndex);
            countMoves++;
            if (firstIndex < 0 || firstIndex >= list.size()
                    || secondIndex < 0 || secondIndex >= list.size()
                    || firstIndex == secondIndex) {
                String elementAdded = String.format("-%da", countMoves);
                list.add(list.size() / 2, elementAdded);
                if (list.size() % 2 != 0) {
                    list.add(list.size() / 2 + 1, elementAdded);
                }
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                if (list.get(firstIndex).equals(list.get(secondIndex))) {
                    System.out.printf("Congrats! You have found matching elements - %s!\n", list.get(firstIndex));
                    list.remove(maxIndex);
                    list.remove(minIndex);
                } else {
                    System.out.println("Try again!");
                }
                if (list.isEmpty()) {
                    System.out.printf("You have won in %d turns!", countMoves);
                    break;
                }
            }
        }
        if(!list.isEmpty()){
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ",list));
        }
    }
}
