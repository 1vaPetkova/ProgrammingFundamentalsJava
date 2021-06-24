package T07associativeArrays.lab;

import java.util.*;

public class P02WordSynonymsv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfPairs = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> synonymDictionary = new LinkedHashMap<>();
        for (int i = 0; i < countOfPairs; i++) {
            String word = scan.nextLine();
            String currSynonym = scan.nextLine();

            if (!synonymDictionary.containsKey(word)){
                List<String> currentWordSynonyms = new ArrayList<>();
                currentWordSynonyms.add(currSynonym);
                synonymDictionary.put(word,currentWordSynonyms);
            } else{
                List<String> currentWordSynonyms = synonymDictionary.get(word);
                currentWordSynonyms.add(currSynonym);
                synonymDictionary.put(word, currentWordSynonyms);
            }
        }
        for (Map.Entry<String, List<String>> entry : synonymDictionary.entrySet()) {
            System.out.printf("%s - %s\n",entry.getKey(),String.join(", ",entry.getValue()));
        }
    }
}
