package finalExamPrep.archive.RetakeExam10Jan2019PartI;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02SantasGifts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lines = Integer.parseInt(scan.nextLine());
        List<Integer> houses = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int currentIndex = 0;
        while (lines-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "Forward":
                    int stepsForward = Integer.parseInt(tokens[1]);
                    if (isInBounds(currentIndex + stepsForward, houses)) {
                        currentIndex = currentIndex + stepsForward;
                        houses.remove(currentIndex);
                    }
                    break;
                case "Back":
                    int stepsBackwards = Integer.parseInt(tokens[1]);
                    if (isInBounds(currentIndex - stepsBackwards, houses)) {
                        currentIndex = currentIndex - stepsBackwards;
                        houses.remove(currentIndex);
                    }
                    break;
                case "Gift":
                    int index = Integer.parseInt(tokens[1]);
                    int houseNumber = Integer.parseInt(tokens[2]);
                    if (isInBounds(index, houses)) {
                        houses.add(index, houseNumber);
                        currentIndex = index;
                    }
                    break;
                case "Swap":
                    int firstElement = Integer.parseInt(tokens[1]);
                    int secondElement = Integer.parseInt(tokens[2]);
                    if (houses.contains(firstElement) && houses.contains(secondElement)) {
                       int firstIndex = houses.indexOf(firstElement);
                        houses.set(houses.indexOf(secondElement), firstElement);
                        houses.set(firstIndex, secondElement);
                    }
                    break;
            }
        }
        System.out.println("Position: " + currentIndex);
        System.out.println(houses.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static boolean isInBounds(int i, List<Integer> houses) {
        return i >= 0 && i < houses.size();
    }
}
