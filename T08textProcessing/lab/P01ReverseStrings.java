package T08textProcessing.lab;

import java.util.Scanner;

public class P01ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        while (!(input = scan.nextLine()).equals("end")) {
            StringBuilder reversed = new StringBuilder();
            for (int i = input.length()-1; i >=0 ; i--) {
                reversed.append(input.charAt(i));
            }
            System.out.println(input +" = "+ reversed.toString());
        }
    }
}
