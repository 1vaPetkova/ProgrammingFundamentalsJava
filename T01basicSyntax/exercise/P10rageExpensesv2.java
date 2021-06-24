package T01basicSyntax.exercise;

import java.util.Scanner;

public class P10rageExpensesv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int gameslost = Integer.parseInt(scan.nextLine());
        double headsetprice = Double.parseDouble(scan.nextLine());
        double mouseprice = Double.parseDouble(scan.nextLine());
        double keyboardprice = Double.parseDouble(scan.nextLine());
        double displayprice = Double.parseDouble(scan.nextLine());

        int headsets = 0;
        int mouses = 0;
        int keyboards = 0;
        int displays = 0;


        headsets = gameslost / 2;
        mouses = gameslost / 3;
        keyboards = gameslost/6;
        displays = gameslost/12;

        double sum = headsetprice * headsets + mouseprice * mouses + keyboardprice * keyboards + displayprice * displays;
        System.out.printf("Rage expenses: %.2f lv.", sum);
    }
}
