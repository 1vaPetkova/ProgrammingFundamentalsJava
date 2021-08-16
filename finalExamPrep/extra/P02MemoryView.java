package finalExamPrep.extra;

import java.util.Arrays;
import java.util.Scanner;

public class P02MemoryView {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";

        StringBuilder sb = new StringBuilder();
        while (!(input = scan.nextLine()).equals("Visual Studio crash")) {
            sb.append(input).append(" ");
        }
        int[] values = Arrays.stream(sb.toString().split("\\s+"))
                .mapToInt(Integer::parseInt).filter(a->a!=0)
                .toArray();
        for (int i = 0; i < values.length; i++) {
            StringBuilder word = new StringBuilder();
            if (values[i] == 32763) {
                int length = values[i + 1];
                for (int j = i + 2; j < i + 2 + length; j++) {
                word.append((char)values[j]);
                }
                System.out.println(word);
            }
        }
    }
}
