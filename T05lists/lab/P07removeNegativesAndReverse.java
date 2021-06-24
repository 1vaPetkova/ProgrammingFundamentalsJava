package T05lists.lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07removeNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) < 0) {
                input.remove(i);
                i = -1;
            }
        }
        Collections.reverse(input);
        if (input.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}

