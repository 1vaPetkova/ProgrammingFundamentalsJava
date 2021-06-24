package T07associativeArrays.lab;

import java.sql.Array;
import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().toLowerCase().split(" ");
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String s : input) {
            if (!counts.containsKey(s)) {
                counts.put(s, 1);
            } else {
                counts.put(s, counts.get(s) + 1);
            }
        }
        List<String> odds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odds.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ",odds));
    }
}
