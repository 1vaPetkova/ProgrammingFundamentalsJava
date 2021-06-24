package T07associativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04Ordersv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Map<String, Double> price = new LinkedHashMap<>();
        Map<String, Integer> qty = new LinkedHashMap<>();

        while (!(input = scan.nextLine()).equals("buy")) {
            String name = input.split("\\s+")[0];
            double currPrice = Double.parseDouble(input.split("\\s+")[1]);
            int quantity = Integer.parseInt(input.split("\\s+")[2]);
            price.putIfAbsent(name, 0.0);
            if (price.get(name) != currPrice) {
                price.put(name, currPrice);
            }
            qty.putIfAbsent(name, 0);
            qty.put(name, qty.get(name) + quantity);
        }
        price.forEach((k, v) -> System.out.printf("%s -> %.2f\n", k, v * qty.get(k)));
    }
}