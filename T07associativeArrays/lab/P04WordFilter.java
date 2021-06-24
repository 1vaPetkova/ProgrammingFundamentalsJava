package T07associativeArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04WordFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Arrays.stream(scan.nextLine().split(" "))
                .filter(word -> word.length() % 2 == 0)
                .forEach(System.out::println);
    }
}
