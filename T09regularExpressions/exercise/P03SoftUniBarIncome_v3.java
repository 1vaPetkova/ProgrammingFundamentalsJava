package T09regularExpressions.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SoftUniBarIncome_v3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^%(?<customer>[A-Z][a-z]+)%(.*)" +
                "<(?<product>\\w+)>(.*)" +
                "\\|(?<count>[0-9]+)\\|([^0-9]*)" +
                "(?<price>[0-9]*[.]?[0-9]*)\\$");
        double totalIncome = 0;
        String input = "";
        while (!(input = scan.nextLine()).equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                System.out.printf("%s: %s - %.2f\n", customer, product, quantity * price);
                totalIncome += quantity * price;
            }
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
