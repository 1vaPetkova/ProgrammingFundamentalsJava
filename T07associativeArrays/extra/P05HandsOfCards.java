package T07associativeArrays.archive;

import java.util.*;
import java.util.stream.Collectors;

public class P05HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> map = new LinkedHashMap<>();
        Map<String, Integer> results = new LinkedHashMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("JOKER")) {
            String personName = input.split(": ")[0];
            List<String> list = Arrays.stream(input.split(": ")[1].split(", "))
                    .collect(Collectors.toList());
            map.putIfAbsent(personName, new ArrayList<>());
            for (String s : list) {
                if (!map.get(personName).contains(s)) {
                    map.get(personName).add(s);
                }
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            int currentSum = 0;
            for (String s : entry.getValue()) {
                currentSum += getPairResult(s);
            }
            results.putIfAbsent(entry.getKey(), currentSum);
        }
        results.entrySet().stream()
                .forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
    }


    private static int getPairResult(String s) {
        String firstSymbol = "";
        String secondSymbol = "";
        firstSymbol = s.substring(0, s.length() - 1);
        secondSymbol = s.split("")[s.length() - 1];

        return power(firstSymbol) * type(secondSymbol);
    }

    private static int type(String secondSymbol) {
        int type = 0;
        switch (secondSymbol) {
            case "S":
                type = 4;
                break;
            case "H":
                type = 3;
                break;
            case "D":
                type = 2;
                break;
            case "C":
                type = 1;
                break;
        }
        return type;
    }

    private static int power(String firstSymbol) {
        int power = 0;
        if (firstSymbol.equals("J") || firstSymbol.equals("Q")
                || firstSymbol.equals("K") || firstSymbol.equals("A")) {
            switch (firstSymbol) {
                case "J":
                    power = 11;
                    break;
                case "Q":
                    power = 12;
                    break;
                case "K":
                    power = 13;
                    break;
                case "A":
                    power = 14;
                    break;
            }
        } else {
            power = Integer.parseInt(firstSymbol);
        }
        return power;
    }
}
