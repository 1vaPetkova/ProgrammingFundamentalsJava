package T07associativeArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((left, right) -> right.compareTo(left))
                .limit(3)
                .forEach(e -> System.out.print(e + " "));
    }
}
