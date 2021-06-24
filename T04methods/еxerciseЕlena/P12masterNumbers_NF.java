package T04methods.еxerciseЕlena;

import java.util.Scanner;

public class P12masterNumbers_NF {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rangeEnd = Integer.parseInt(scan.nextLine());
        printAllMasterNumbers(rangeEnd);

    }

    private static void printAllMasterNumbers(int rangeEnd) {

        for (int i = 1; i <= rangeEnd; i++) {
            if (isPalindrome(i)) {

            }

        }
    }

    private static boolean isPalindrome(int num) {
        String[] numberText = String.valueOf(num).split("");
        int[] digits = new int[numberText.length];
        if (digits.length==1){
            return true;
        }

return false;
    }
}
