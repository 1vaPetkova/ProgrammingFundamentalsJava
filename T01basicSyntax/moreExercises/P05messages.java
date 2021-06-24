package T01basicSyntax.moreExercises;

import java.util.Scanner;

public class P05messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countLetters = Integer.parseInt(scan.nextLine());
        StringBuilder outputBuilder = new StringBuilder();

        for (int i = 1; i <= countLetters; i++) {
            int num = Integer.parseInt(scan.nextLine());
            int numLenght = 0;
            int digit = num % 10;
            while (num > 0) {
                numLenght++;
                num = num / 10;
            }
            int offset = (digit - 2) * 3;
            if (digit == 8 || digit == 9) {
                offset += 1;
            }
            int index = offset + numLenght - 1;
            int newIndex = 'a' + index;
            char letter = (char) newIndex;
            if (digit == 0) {
                letter = ' ';
            }
            outputBuilder.append(letter);
        }
        String output = outputBuilder.toString();
        System.out.print(output);
    }
}



