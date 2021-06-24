package T05lists.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07appendArraysv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        List<String> arrays = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        Collections.reverse(arrays);
        String toPrint = arrays.toString().replaceAll("[\\[\\],]", "");
        toPrint = toPrint.replaceAll("\\s+"," ");
        System.out.println(toPrint);


    }
}
