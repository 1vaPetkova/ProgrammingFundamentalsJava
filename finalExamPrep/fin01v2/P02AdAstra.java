package finalExamPrep.fin01v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([#]|[\\|])(?<itemName>[A-Za-z ]+)\\1" +
                "(?<expiration>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1" +
                "(?<calories>\\d+)\\1");
        Matcher matcher = pattern.matcher(scan.nextLine());
        int totalCalories = 0;
        List<String[]> food = new ArrayList<>();
        while (matcher.find()) {
            String item = matcher.group("itemName");
            String expiration = matcher.group("expiration");
            String cals = matcher.group("calories");
            totalCalories += Integer.parseInt(cals);
            String[] data = new String[3];
            data[0] = item;
            data[1] = expiration;
            data[2] = cals;
            food.add(data);
        }
        System.out.printf("You have food to last you for: %d days!\n", totalCalories / 2000);
        food.forEach(f -> System.out.printf("Item: %s, Best before: %s, Nutrition: %s\n", f[0], f[1], f[2]));
    }
}
