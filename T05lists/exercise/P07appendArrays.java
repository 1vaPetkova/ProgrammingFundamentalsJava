package T05lists.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07appendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());
        Collections.reverse(list);
        String output = list.toString().replaceAll("[\\[\\],]","").replaceAll("\\s+"," ").trim();
        System.out.println(output);
    }
}
