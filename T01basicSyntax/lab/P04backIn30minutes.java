package T01basicSyntax.lab;

import java.util.Scanner;

public class P04backIn30minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());
        int allmins = hours * 60 + minutes;
        int minsplus30 = allmins + 30;
        int newhours = minsplus30 / 60;
        int newmins = minsplus30 % 60;
        if (newhours>23){
            newhours=0;
        }
        System.out.printf("%d:%02d",newhours,newmins);

    }
}
