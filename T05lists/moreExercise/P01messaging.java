package T05lists.moreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<String> text = Arrays.stream(scan.nextLine().split(""))
                .collect(Collectors.toList());
        StringBuilder messageBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int currentNumber = list.get(i);
            int sumDigits = 0;
            int lastDigit = 0;
            while (currentNumber > 0) {
                lastDigit = currentNumber % 10;
                sumDigits += lastDigit;
                currentNumber /= 10;
            }
            int rounds = sumDigits / text.size();
            int diff = sumDigits - rounds * text.size();
            messageBuilder.append(text.get(diff));
            text.remove(diff);
        }
        System.out.println(messageBuilder.toString());
    }
}

