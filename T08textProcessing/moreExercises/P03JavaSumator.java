package T08textProcessing.moreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03JavaSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] keys = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = "";
        while (!(input = scan.nextLine()).equals("find")) {
            int keyCounter = 0;
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char newValue = (char) (input.charAt(i) - keys[keyCounter]);
                output.append(newValue);
                keyCounter++;
                if (keyCounter == keys.length) {
                    keyCounter = 0;
                }
            }
            String type = output.substring(output.indexOf("&") + 1, output.lastIndexOf("&"));
            String coordinates = output.substring(output.indexOf("<") + 1, output.lastIndexOf(">"));
            System.out.printf("Found %s at %s\n",type,coordinates);
        }
    }
}
