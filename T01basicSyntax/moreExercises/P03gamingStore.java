package T01basicSyntax.moreExercises;

import java.util.Scanner;

public class P03gamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double currentBalance = Double.parseDouble(scan.nextLine());
        String input = scan.nextLine();
        double unitPrice = 0;

        double moneySpent = 0;
        while (!input.equals("Game Time")) {
            boolean isWrong = false;
            boolean isExpensive = false;
            switch (input) {
                case "OutFall 4":
                    unitPrice = 39.99;
                    break;
                case "CS: OG":
                    unitPrice = 15.99;
                    break;
                case "Zplinter Zell":
                    unitPrice = 19.99;
                    break;
                case "Honored 2":
                    unitPrice = 59.99;
                    break;
                case "RoverWatch":
                    unitPrice = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    unitPrice = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    isWrong = true;
                    break;
            }
            if (currentBalance == unitPrice) {
                System.out.println("Out of money!");
                currentBalance-=unitPrice;
                break;
            } else if (currentBalance < unitPrice) {
                System.out.println("Too Expensive");
                isExpensive = true;
            }
            if (!isWrong && !isExpensive) {
                System.out.printf("Bought %s\n", input);
                currentBalance -= unitPrice;
                moneySpent += unitPrice;
            }
            input = scan.nextLine();
        }
        if (currentBalance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", moneySpent, currentBalance);
        }
    }
}
