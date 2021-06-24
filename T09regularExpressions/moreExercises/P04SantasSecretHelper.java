package T09regularExpressions.moreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        String input = "";
        Map<String, String> map = new LinkedHashMap<>();
        while (!(input = scan.nextLine()).equals("end")) {
            StringBuilder message = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                message.append((char) (input.charAt(i) - key));
            }
            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)(?:[^@\\-!:>]*?)!(?<type>[GN])!");
            Matcher matcher = pattern.matcher(message.toString());
            while (matcher.find()) {
                map.putIfAbsent(matcher.group("name"), "");
                map.put(matcher.group("name"), matcher.group("type"));
            }
        }

        map.entrySet().stream().filter(kid -> kid.getValue().equals("G"))
                .forEach(e -> System.out.println(e.getKey()));
    }
}
