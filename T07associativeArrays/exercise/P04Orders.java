package T07associativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Map<String, Double> map = new LinkedHashMap<>();
        Map<String, Integer> qty = new LinkedHashMap<>();
        double price = 0;
        while (!(input = scan.nextLine()).equals("buy")) {
            String name = input.split("\\s+")[0];
            double currPrice = Double.parseDouble(input.split("\\s+")[1]);
            int quantity = Integer.parseInt(input.split("\\s+")[2]);
            double totalPrice = currPrice * quantity;
            if (!map.containsKey(name)) {
                map.put(name, currPrice);
                qty.put(name, quantity);
            } else {
                if (map.get(name) != currPrice) {
                    map.put(name, currPrice);
                }
                qty.put(name, qty.get(name) + quantity);
            }
        }
        map.forEach((k, v) -> System.out.printf("%s -> %.2f\n", k, v * qty.get(k)));
    }
}