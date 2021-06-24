package T07associativeArrays.moreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P04Snowwhite {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Integer> dwarfs = new LinkedHashMap<>();
        Map<String, Integer> counter = new LinkedHashMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("Once upon a time")) {
            String name = input.split(" <:> ")[0];
            String hatColor = input.split(" <:> ")[1];
            String key = name + " " + hatColor;
            int physics = Integer.parseInt(input.split(" <:> ")[2]);
            dwarfs.putIfAbsent(key, 0);
            dwarfs.put(key, Math.max(dwarfs.get(key), physics));
            counter.putIfAbsent(hatColor, 0);
            counter.put(hatColor, counter.get(hatColor) + 1);
        }
        dwarfs = dwarfs.entrySet().stream().sorted((f, s) -> {
            if (s.getValue().equals(f.getValue())) {
                Integer firstValue = counter.get(s.getKey().split(" ")[1]);
                Integer secondValue = counter.get(f.getKey().split(" ")[1]);
                return firstValue.compareTo(secondValue);
            }
            return s.getValue().compareTo(f.getValue());
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : dwarfs.entrySet()) {
            String dwarfName = entry.getKey().split(" ")[0];
            String hatColor = entry.getKey().split(" ")[1];
            System.out.printf("(%s) %s <-> %d\n",hatColor,dwarfName,entry.getValue());
        }
    }
}