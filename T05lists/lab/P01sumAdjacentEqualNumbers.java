package T05lists.lab;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01sumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> numberList = Arrays.stream(scan.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        for (int i = 0; i < numberList.size() - 1; i++) {//we check till the first to last element!
            if (numberList.get(i).equals(numberList.get(i + 1))) {
                double sum = numberList.get(i) + numberList.get(i + 1);
                numberList.set(i, sum);
                numberList.remove(i + 1);
                i = -1;
            }
        }
        DecimalFormat df = new DecimalFormat("#.#");
        for (double value : numberList) {
            System.out.print(df.format(value) + " ");
        }
    }
}
