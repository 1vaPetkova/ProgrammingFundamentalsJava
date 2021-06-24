package T01basicSyntax.exercise;

import java.util.Scanner;

public class P07vendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input1 = scan.nextLine();
        double sum = 0;
        while (!input1.equals("Start")) {
            double currentCoins = Double.parseDouble(input1);
            if (currentCoins != 0.1 && currentCoins != 0.2 && currentCoins != 0.5 &&
                    currentCoins != 1 && currentCoins != 2) {
                System.out.printf("Cannot accept %.2f\n", currentCoins);
            } else {
                sum += currentCoins;
            }
            input1 = scan.nextLine();
        }
        String input2 = scan.nextLine();
        double unitPrice = 0;
        double change = 0;
        boolean isInvalid = false;
        while (!input2.equals("End")) {
            String product = input2;
            switch (input2) {
                case "Nuts":
                    unitPrice = 2;
                    break;
                case "Water":
                    unitPrice = .7;
                    break;
                case "Crisps":
                    unitPrice = 1.5;
                    break;
                case "Soda":
                    unitPrice = .8;
                    break;
                case "Coke":
                    unitPrice = 1;
                    break;
                default:
                    System.out.println("Invalid product");
                    isInvalid = true;
                    break;
            }
            if (sum < unitPrice) {
                System.out.println("Sorry, not enough money");
            } else if (sum >= unitPrice && !isInvalid) {
                System.out.printf("Purchased %s\n", product);
                sum -= unitPrice;
                change = sum;
            }
            input2 = scan.nextLine();
        }
        System.out.printf("Change: %.2f", change);
    }
}
