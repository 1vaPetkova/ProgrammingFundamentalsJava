package T05lists.moreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05drumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double savings = Double.parseDouble(scan.nextLine());
        List<Integer> initialQuality = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> currentQuality = new ArrayList<>();
        for (int index = 0; index < initialQuality.size(); index++) {
            currentQuality.add(index, initialQuality.get(index));
        }
        String input = "";
        while (!(input = scan.nextLine()).equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < currentQuality.size(); i++) {
                if (currentQuality.get(i) != 0) {
                    currentQuality.set(i, currentQuality.get(i) - hitPower);
                    if (currentQuality.get(i) <= 0) {
                        currentQuality.set(i, initialQuality.get(i));
                        double newSetPrice = initialQuality.get(i) * 3;
                        savings -= newSetPrice;
                        if (savings <= 0) {
                            savings += newSetPrice;
                            currentQuality.set(i, 0);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < currentQuality.size(); i++) {
            if (currentQuality.get(i) == 0) {
                currentQuality.remove(i);
                i--;
            }
        }
        for (int value : currentQuality) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
