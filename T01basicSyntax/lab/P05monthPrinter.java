package T01basicSyntax.lab;

import java.util.Scanner;

public class P05monthPrinter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int monthnum = Integer.parseInt(scan.nextLine());
        String name = "";
        switch (monthnum) {
            case 1:
                name = "January";
                break;
            case 2:
                name = "February";
                break;
            case 3:
                name = "March";
                break;
            case 4:
                name = "April";
                break;
            case 5:
                name = "May";
                break;
            case 6:
                name = "June";
                break;
            case 7:
                name = "July";
                break;
            case 8:
                name = "August";
                break;
            case 9:
                name = "September";
                break;
            case 10:
                name = "October";
                break;
            case 11:
                name = "November";
                break;
            case 12:
                name = "December";
                break;
            default:
                name = "Error!";
                break;
        }
        System.out.println(name);
    }
}
