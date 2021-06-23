package finalExamPrep.fin01;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("([\\|]|[#])(?<item>[A-Za-z\\s+]+)\\1" +
                "(?<expiration>\\d{2}\\/\\d{2}\\/\\d{2})\\1" +
                "(?<kcals>\\d+)\\1");
        Matcher matcher = pattern.matcher(input);
        int totalCalories = 0;
        List<String> output = new ArrayList<>();
        while (matcher.find()) {
            String item = matcher.group("item");
            String expirationDate = matcher.group("expiration");
            int cals = Integer.parseInt(matcher.group("kcals"));
            output.add(String.format("Item: %s, Best before: %s, Nutrition: %d", item, expirationDate, cals));
            totalCalories += cals;
        }

        System.out.printf("You have food to last you for: %d days!\n", totalCalories / 2000);
        for (String s : output) {
            System.out.println(s);
        }
    }
}
