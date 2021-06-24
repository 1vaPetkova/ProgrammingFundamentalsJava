package T09regularExpressions.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SoftUniBarIncomev2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        String regex = "%(?<name>([A-Z][a-z]+))%(?:[^|$%.]*)" +
                "<(?<product>\\w+)>(?:[^|$%.]*)" +
                "\\|(?<qty>\\d+)\\|(?:[^|$%.]*?)" +
                "(?<price>\\d+\\.?\\d*)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalIncome = 0;
        while (!(input = scan.nextLine()).equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                int quantity = Integer.parseInt(matcher.group("qty"));
                double unitPrice = Double.parseDouble(matcher.group("price"));
                double totalPrice = quantity * unitPrice;
                totalIncome += totalPrice;
                System.out.printf("%s: %s - %.2f\n",
                        matcher.group("name"), matcher.group("product"), totalPrice);
            }
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
