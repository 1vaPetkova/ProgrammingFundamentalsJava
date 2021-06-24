package T05lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02gaussTrickv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int initialSize = numbers.size();
        for (int i = 0; i < initialSize/2; i++) {
            int currentElement = numbers.get(i);
            int oppositeElement = numbers.get(numbers.size() - 1);
             numbers.set(i,currentElement+oppositeElement);
             numbers.remove(numbers.size()-1);
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
