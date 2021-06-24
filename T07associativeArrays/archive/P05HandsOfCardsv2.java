package T07associativeArrays.archive;

import java.util.*;
import java.util.stream.Collectors;

public class P05HandsOfCardsv2 {
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
        HashMap<String, Integer> T = new HashMap<>();
        T.put("S", 4);
        T.put("H", 3);
        T.put("D", 2);
        T.put("C", 1);
        return T.get(secondSymbol);
    }

    private static int power(String firstSymbol) {
        Map<String, Integer> P = new HashMap<>();
        try {
            P.put(firstSymbol, Integer.parseInt(firstSymbol));
        } catch (Exception e) {
            P.put("J", 11);
            P.put("Q", 12);
            P.put("K", 13);
            P.put("A", 14);
        }
        return P.get(firstSymbol);
    }
}
