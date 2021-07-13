package midExamPrep.mid01v2;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double priceWoVAT = 0;

        String input = scan.nextLine();
        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price <= 0) {
                System.out.println("Invalid price!");
                input = scan.nextLine();
                continue;
            }
            priceWoVAT += price;
            input = scan.nextLine();
        }
        double totalPrice = 1.2*priceWoVAT;
        if (priceWoVAT == 0) {
            System.out.println("Invalid order!");
        } else {

            if (input.equals("special")) {
                //discount is applied on the total price with vat!!!
                totalPrice *= 0.9;
            }

            System.out.printf("Congratulations you've just bought a new computer!\n" +
                    "Price without taxes: %.2f$\n" +
                    "Taxes: %.2f$\n" +
                    "-----------\n" +
                    "Total price: %.2f$\n", priceWoVAT, priceWoVAT*0.2, totalPrice);
        }
    }
}
