package T03arrays.archive;

import java.util.Scanner;

public class P05compareCharArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array1 = scan.nextLine().split(" ");
        String[] array2 = scan.nextLine().split(" ");

        String[] shorter = new String[Math.min(array1.length, array2.length)];
        String[] longer = new String[Math.max(array1.length, array2.length)];
        if (array1.length < array2.length) {
            shorter = array1;
            longer = array2;
        } else {
            shorter = array2;
            longer = array1;
        }
        String output1 = "";
        String output2 = "";

        for (int i = 0; i < Math.min(array1.length, array2.length); i++) {
            if (array1[i].equals(array2[i])) {
                output1 = String.join("", shorter);
                output2 = String.join("", longer);
            } else if (array1[i].charAt(0) < array2[i].charAt(0)) {
                output1 = String.join("", array1);
                output2 = String.join("", array2);
                break;
            } else {
                output1 = String.join("", array2);
                output2 = String.join("", array1);
                break;
            }
        }
        System.out.println(output1);
        System.out.println(output2);

    }
}
