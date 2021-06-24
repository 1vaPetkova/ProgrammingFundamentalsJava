package T05lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09pokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> sequence = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = 0;
        while (!sequence.isEmpty()) {
            int currentIndex = Integer.parseInt(scan.nextLine());
            int removedElement = 0;
            if (currentIndex < 0) {
                int lastElement = sequence.get(sequence.size() - 1);
                removedElement = sequence.get(0);
                sequence.set(0, lastElement);
                increaseAndDecreaseValues(sequence, removedElement);
            } else if (currentIndex > sequence.size() - 1) {
                int firstElement = sequence.get(0);
                removedElement = sequence.get(sequence.size() - 1);
                sequence.set(sequence.size() - 1, firstElement);
                increaseAndDecreaseValues(sequence, removedElement);
            } else {
                removedElement = sequence.get(currentIndex);
                sequence.remove(currentIndex);
                increaseAndDecreaseValues(sequence, removedElement);
            }
            sum += removedElement;
        }
        System.out.println(sum);
    }

    private static void increaseAndDecreaseValues(List<Integer> sequence, int removedElement) {
        for (int i = 0; i < sequence.size(); i++) {
            if (sequence.get(i) <= removedElement) {
                sequence.set(i, sequence.get(i) + removedElement);
            } else {
                sequence.set(i, sequence.get(i) - removedElement);
            }
        }
    }
}
