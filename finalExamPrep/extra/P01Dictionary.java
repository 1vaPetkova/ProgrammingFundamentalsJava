package finalExamPrep.extra;

import java.util.*;
import java.util.stream.Collectors;

public class P01Dictionary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] wordsWithDefinitions = scan.nextLine().split(" \\| ");
        Map<String, List<String>> dictionary = new TreeMap<>();
        for (String w : wordsWithDefinitions) {
            String[] info = w.split(": ");
            dictionary.putIfAbsent(info[0], new ArrayList<>());
        dictionary.get(info[0]).add(info[1]);
        }
        List<String> outputWords = Arrays.stream(scan.nextLine().split(" \\| "))
                .collect(Collectors.toList());
        String command = scan.nextLine();
        dictionary.entrySet().stream().filter(e -> outputWords.contains(e.getKey()))
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");
                    e.getValue().stream().sorted((f, s) -> Integer.compare(s.length(), f.length()))
                            .forEach(d -> System.out.println(" -" + d));
                });
        if (command.equals("List")) {
            dictionary.forEach((k, v) -> System.out.print(k + " "));
        }
    }
}
