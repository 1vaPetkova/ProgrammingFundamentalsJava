package T07associativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String resource = "";
        Map<String, Integer> map = new LinkedHashMap<>();
        while (!(resource = scan.nextLine()).equals("stop")) {
            int currQuantity = Integer.parseInt(scan.nextLine());
            if (!map.containsKey(resource)) {
                map.put(resource, currQuantity);
            } else {
                map.put(resource, map.get(resource) + currQuantity);
            }
        }
        map.forEach((k, v) -> System.out.println(k + " -> " + v));

    }
}
