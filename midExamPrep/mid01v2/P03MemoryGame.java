package midExamPrep.mid01v2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> elements = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = "";
        int countMoves = 0;

        while (!(input = scan.nextLine()).equals("end")) {
            int firstIndex = Integer.parseInt(input.split("\\s+")[0]);
            int secondIndex = Integer.parseInt(input.split("\\s+")[1]);
            countMoves++;

            if (firstIndex == secondIndex | !isInBounds(firstIndex, elements) | !isInBounds(secondIndex, elements)) {
                elements.add(elements.size() / 2, String.format("-%da", countMoves));
                elements.add(elements.size() / 2, String.format("-%da", countMoves));
                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (elements.get(firstIndex).equals(elements.get(secondIndex))) {
                System.out.printf("Congrats! You have found matching elements - %s!\n", elements.get(firstIndex));
               elements.removeAll(List.of(elements.get(firstIndex)));
            } else if (!elements.get(firstIndex).equals(elements.get(secondIndex))) {
                System.out.println("Try again!");
            }
            if (elements.isEmpty()) {
                System.out.printf("You have won in %d turns!\n", countMoves);
                break;
            }
        }
        if (!elements.isEmpty()) {
            System.out.println("Sorry you lose :(\n" + String.join(" ", elements));

            }

        }

        private static boolean isInBounds ( int index,List<String> elements){
            return index >= 0 && index < elements.size();
        }
    }
