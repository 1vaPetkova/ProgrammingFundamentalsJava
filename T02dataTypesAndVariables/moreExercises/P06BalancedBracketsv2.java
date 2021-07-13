package T02dataTypesAndVariables.moreExercises;

import java.util.Scanner;

public class P06BalancedBracketsv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        boolean isOpen = false;
        boolean isBalanced = false;
        boolean isClosed = false;
        int countOpen = 0;
        while (n-- > 0) {
            String line = scan.nextLine();
            if (line.equals("(")) {
                countOpen++;
                isOpen = true;
                isBalanced = false;
            } else if (line.equals(")")) {
                countOpen--;
                isClosed = true;
            }
            if (isClosed && !isOpen) {
                isBalanced = false;
                break;
            }
            if (isOpen && isClosed && countOpen == 0) {
                isBalanced = true;
                isOpen = false;
                isClosed = false;
            }
        }
        if (isBalanced) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
