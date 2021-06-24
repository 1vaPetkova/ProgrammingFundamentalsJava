package T04methods.exercise;

import java.util.Scanner;

public class P06middleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        getMiddleCharacters(input);
    }

    private static void getMiddleCharacters(String input) {
        String[] array = input.split("");
        String middleChar = "";
        if (array.length % 2 != 0) {
            middleChar = array[array.length / 2];
        } else {
            middleChar = array[array.length/2-1]+array[array.length/2];
        }
        System.out.println(middleChar);
    }
}
