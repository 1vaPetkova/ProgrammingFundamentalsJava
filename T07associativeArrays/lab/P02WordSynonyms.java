package T07associativeArrays.lab;

import java.util.*;

public class P02WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfPairs = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> synonymDictionary = new LinkedHashMap<>();
        for (int i = 0; i < countOfPairs; i++) {
            String word = scan.nextLine();
            String currSynonym = scan.nextLine();

            synonymDictionary.putIfAbsent(word,new ArrayList<>());
            synonymDictionary.get(word).add(currSynonym);
        }
        for (Map.Entry<String, List<String>> entry : synonymDictionary.entrySet()) {
            System.out.printf("%s - %s\n",entry.getKey(),String.join(", ",entry.getValue()));
        }
    }
}
