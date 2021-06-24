package T05lists.moreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03takeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> input = Arrays.stream(scan.nextLine().split(""))
                .collect(Collectors.toList());
        List<String> numbersList = new ArrayList<>();
        List<String> nonNumbersList = new ArrayList<>();

        //divide input into numbersList and nonNumbersList
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).charAt(0) >= '0' && input.get(i).charAt(0) <= '9') {
                numbersList.add(input.get(i));
                input.remove(i);
                i--;
            } else {
                nonNumbersList.add(input.get(i));
                input.remove(i);
                i--;
            }
        }
        //divide numbers into skip and take lists
        List<Integer> numbers = numbersList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> take = new ArrayList<>();
        List<Integer> skip = new ArrayList<>();
        for (int j = 0; j < numbers.size(); j++) {
            if (j % 2 == 0) {
                take.add(numbers.get(j));
            } else {
                skip.add(numbers.get(j));
            }
        }
        //take and skip elements
        List<String> result = new ArrayList<>();
        //take and skip iterations are equal the length of the list
        int index = 0;
            for (int iteration = 0; iteration < take.size(); iteration++) {
                int charsTaken = take.get(iteration);
                int charsSkipped = skip.get(iteration);
                //take count Take elements
                for (int j = 0; j < charsTaken; j++) {
                    if (index + j <= nonNumbersList.size() - 1) {
                        result.add(nonNumbersList.get(index + j));
                    }
                }
                index += charsTaken;
                //skip countSkip elements
                index += charsSkipped;
            }
        System.out.println(String.join("", result));
    }
}
