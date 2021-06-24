package T08textProcessing.exercise;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split(", ");
        boolean isValid = false;
        for (String name : names) {
            if (name.length() >= 3 && name.length() <= 16) {
                for (int i = 0; i < name.length(); i++) {
                    if (Character.isLetterOrDigit(name.charAt(i))
                            || name.charAt(i) == '-'
                            || name.charAt(i) == '_') {
                        isValid = true;
                    } else {
                        isValid = false;
                        break;
                    }
                }
                    if (isValid) {
                        System.out.println(name);
                    }
            }
        }
    }
}

