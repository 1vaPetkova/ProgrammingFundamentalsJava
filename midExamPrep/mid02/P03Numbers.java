package midExamPrep.mid02;

import java.util.*;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        double averageNumber = list.stream().mapToDouble(a -> a).average().orElse(0.0);
        List<Integer> topList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > averageNumber) {
                topList.add(list.get(i));
            }
        }
        topList.sort(Collections.reverseOrder());
        if (topList.isEmpty()) {
            System.out.println("No");
        } else {
            topList.stream().limit(5).forEach(e -> System.out.print(e + " "));
        }
    }
}
