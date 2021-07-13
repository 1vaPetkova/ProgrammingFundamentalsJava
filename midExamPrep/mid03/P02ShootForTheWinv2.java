package midExamPrep.mid03;

import java.util.Arrays;
import java.util.Scanner;

public class P02ShootForTheWinv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] targets = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {
            int index = Integer.parseInt(input);
            if (isValid(index, targets)) {
                int value = targets[index];
                targets[index] = -1;
                for (int i = 0; i < targets.length; i++) {
                    if (i != index) {
                        if (targets[i] > value && targets[i] != -1) {
                            targets[i] -= value;
                            if (targets[i] <= 0) {
                                targets[i] = -1;
                            }
                        } else if (targets[i] <= value && targets[i] != -1) {
                            targets[i] += value;
                        }
                    }
                }
            }
        }
        int count = 0;
        StringBuilder output = new StringBuilder();
        for (int target : targets) {
            if(target==-1){
                count++;
            }
           output.append(target).append(" ");
        }
        System.out.printf("Shot targets: %d -> ", count);
        System.out.print(output);
    }

    private static boolean isValid(int index, int[] targets) {
        return index >= 0 && index < targets.length;
    }
}
