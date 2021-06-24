package T08textProcessing.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01ReverseStringsv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";

        while (!(input = scan.nextLine()).equals("end")) {
            System.out.print(input + " = ");
            List<String> list = Arrays.stream(input.split(""))
                    .collect(Collectors.toList());
            for (int i = 0; i < list.size() / 2; i++) {
                String temp = list.get(list.size() - 1 - i);
                list.set(list.size() - 1 - i, list.get(i));
                list.set(i, temp);
            }
            System.out.println(String.join("", list));
        }
    }
}
