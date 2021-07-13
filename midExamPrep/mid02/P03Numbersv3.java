package midExamPrep.mid02;

import java.util.*;
import java.util.stream.Collectors;

public class P03Numbersv3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        double average = list.stream().mapToDouble(a -> a).average().orElse(0);
        list = list.stream().filter(a -> a > average).sorted(Comparator.reverseOrder()).limit(5).collect(Collectors.toList());
        if (!list.isEmpty()) {
            list.forEach(e -> System.out.print(e + " "));
        } else {
            System.out.println("No");
        }

    }
}
