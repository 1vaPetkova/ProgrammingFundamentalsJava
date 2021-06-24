package T02dataTypesAndVariables.moreExercises;

import java.util.Scanner;

public class P06balancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nLines = Integer.parseInt(scan.nextLine());
        boolean isOpen = false;
        boolean isClosed = false;
        boolean isBalanced = false;
        int count = 0;
        for (int i = 0; i < nLines; i++) {
            String input = scan.nextLine();
            if (input.equals("(")) {
                isOpen = true;
                isBalanced = false;
                count++;
            } else if (input.equals(")")) {
                isClosed = true;
                count++;
            }
            if (isClosed && !isOpen){
                isBalanced = false;
                break;
            }
            if (isOpen && isClosed && count == 2) {
                isBalanced = true;
                count = 0;
                isOpen = false;
                isClosed = false;
            }
        }
        if (isBalanced){
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
