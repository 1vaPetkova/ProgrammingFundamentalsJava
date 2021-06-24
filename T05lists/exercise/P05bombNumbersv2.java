package T05lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05bombNumbersv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> bombNumberAndPower = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int bombNumber = bombNumberAndPower.get(0);
        int power = bombNumberAndPower.get(1);
        for (int i = 0; i < list.size(); i++) {
            //remove the left numbers
            if (list.get(i) == bombNumber) {
                for (int j = 0; j < power; j++) {
                    if (i > 0) {
                        list.remove(i - 1);
                        i--;
                    }
                }
                //remove the right numbers
                for (int k = 0; k < power; k++) {
                    if (i < list.size() - 1) {
                        list.remove(i + 1);
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)==bombNumber){
                list.remove(i);
                i--;
            }
        }
        int sum = 0;
        for (int value : list) {
                sum += value;
        }
        System.out.println(sum);
    }
}

