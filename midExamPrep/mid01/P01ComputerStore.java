package midExamPrep.mid01;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        double sum = 0;
        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price <= 0) {
                System.out.println("Invalid price!");
                input = scan.nextLine();
                continue;
            }
            sum += price;
            input = scan.nextLine();
        }
        double totalPrice = sum * 1.2;
        if (input.equals("special")) {
            totalPrice *= 0.9;
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.printf("Congratulations you've just bought a new computer!\n" +
                    "Price without taxes: %.2f$\n" +
                    "Taxes: %.2f$\n" +
                    "-----------\n" +
                    "Total price: %.2f$\n", sum, 0.2 * sum, totalPrice);
        }

    }
}
