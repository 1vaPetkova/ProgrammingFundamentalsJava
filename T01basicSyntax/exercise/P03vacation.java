package T01basicSyntax.exercise;

import java.util.Scanner;

public class P03vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        String grouptype = scan.nextLine();
        String dayoftheweek = scan.nextLine();
        double price = 0;
        switch (grouptype) {
            case "Students":
                if (dayoftheweek.equals("Friday")) {
                    price = 8.45;
                } else if (dayoftheweek.equals("Saturday")) {
                    price = 9.80;
                } else {
                    price = 10.46;
                }
                break;
            case "Business":
                if (dayoftheweek.equals("Friday")) {
                    price = 10.90;
                } else if (dayoftheweek.equals("Saturday")) {
                    price = 15.60;
                } else {
                    price = 16;
                }
                break;
            case "Regular":
                if (dayoftheweek.equals("Friday")) {
                    price = 15;
                } else if (dayoftheweek.equals("Saturday")) {
                    price = 20;
                } else {
                    price = 22.50;
                }
                break;
        }
        double sum = price * people;
        if (people >= 30 && grouptype.equals("Students")) {
            sum *= .85;
        } else if (people >= 100 && grouptype.equals("Business")) {
            sum -= 10 * price;
        } else if (people >= 10 && people <= 20 && grouptype.equals("Regular")) {
            sum *= .95;
        }
        System.out.printf("Total price: %.2f", sum);
    }
}
