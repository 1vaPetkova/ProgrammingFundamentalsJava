package T07associativeArrays.lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Double, Integer> counts = new TreeMap<>();
        double[] nums = Arrays.stream(scan.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        for (double number : nums) {
            if (!counts.containsKey(number)) {
                counts.put(number, 1);
            } else {
                int occurrences = counts.get(number);
                occurrences++;
                counts.put(number, occurrences);
            }
        }
        DecimalFormat df = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.printf("%s -> %d\n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
