package midExamPrep.mid02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = "";
        int firstIndex = 0;
        int secondIndex = 0;
        while (!(input = scan.nextLine()).equals("end")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "swap":
                    firstIndex = Integer.parseInt(tokens[1]);
                    secondIndex = Integer.parseInt(tokens[2]);
                    int firstNumber = list.get(firstIndex);
                    int secondNumber = list.get(secondIndex);
                    list.set(firstIndex, secondNumber);
                    list.set(secondIndex, firstNumber);
                    break;
                case "multiply":
                    firstIndex = Integer.parseInt(tokens[1]);
                    secondIndex = Integer.parseInt(tokens[2]);
                    list.set(firstIndex, list.get(firstIndex) * list.get(secondIndex));
                    break;
                case "decrease":
                    for (int i = 0; i <list.size(); i++) {
                        list.set(i, list.get(i)-1);
                    }
                    break;
            }
        }
        System.out.println(list.toString().replaceAll("[\\[\\]]",""));
    }
}
