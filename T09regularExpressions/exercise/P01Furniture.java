package T09regularExpressions.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double sum = 0;
        System.out.println("Bought furniture:");
        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile(">>(?<name>.*)<<(?<price>\\d+.\\d*)!(?<quantity>\\d+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furnitureName = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                sum += price * quantity;
                System.out.println(furnitureName);
            }
            input = scan.nextLine();
        }
        System.out.printf("Total money spend: %.2f", sum);

    }
}
