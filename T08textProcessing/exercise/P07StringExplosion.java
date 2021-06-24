package T08textProcessing.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split(""))
                .collect(Collectors.toList());
        int strength = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(">")) {
                strength += Integer.parseInt(list.get(i + 1));
            } else {
                if(strength > 0) {
                list.remove(i);
                strength--;
                i--;
            }
        }
    }
        System.out.println(String.join("",list));
}
}
