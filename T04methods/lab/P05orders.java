package T04methods.lab;

import java.util.Scanner;

public class P05orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String order = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());


        calculateTotalPrice(order, quantity);
    }

    private static void calculateTotalPrice(String order, int quantity) {
        double unitPrice = 0;
        switch (order){
            case "coffee":
                unitPrice = 1.50;
                break;
            case "water":
                unitPrice = 1.00;
                break;
            case "coke":
                unitPrice = 1.40;
                break;
            case "snacks":
                unitPrice = 2;
                break;
        }
        double totalPrice = unitPrice*quantity;
        System.out.printf("%.2f",totalPrice);
    }
}
