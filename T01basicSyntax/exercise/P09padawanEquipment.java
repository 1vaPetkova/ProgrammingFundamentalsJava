package T01basicSyntax.exercise;

import java.util.Scanner;

public class P09padawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double money = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double lightsabersPrice = Double.parseDouble(scan.nextLine());
        double robesPrice = Double.parseDouble(scan.nextLine());
        double beltsPrice = Double.parseDouble(scan.nextLine());
        int lightsabers = (int) Math.ceil(1.1 * students);
        int beltsToPay = (int) Math.ceil(students * (5.0/6));
        double total = lightsabers * lightsabersPrice + students * robesPrice + beltsToPay * beltsPrice;
        if (money >= total) {
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", total - money);
        }
    }
}
