package midExam20210710;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("Finish")) {
            int value = Integer.parseInt(input.split("\\s+")[1]);
            switch (input.split("\\s+")[0]) {
                case "Add":
                    list.add(value);
                    break;
                case "Remove":
                    if (list.contains(value)) {
                        list.remove((Integer) value);
                    }
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(input.split("\\s+")[2]);
                    if (list.contains(value)) {
                        int index = list.indexOf(value);
                        list.set(index, replacement);
                    }
                    break;
                case "Collapse":
                    list = list.stream().filter(a -> a >= value).collect(Collectors.toList());
                    break;
            }
        }
        list.forEach(e -> System.out.print(e + " "));
    }
}
