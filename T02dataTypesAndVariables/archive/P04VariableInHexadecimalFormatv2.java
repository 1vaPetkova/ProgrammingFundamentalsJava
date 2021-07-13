package T02dataTypesAndVariables.archive;

import java.util.Scanner;

public class P04VariableInHexadecimalFormatv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] hexadecimal = scan.nextLine().substring(2).split("");
        int sum = 0;
        for (int i = 0; i < hexadecimal.length; i++) {
            int num = 0;
            try {
                num = Integer.parseInt(hexadecimal[i]);
            } catch (Exception E) {
                switch (hexadecimal[i]) {
                    case "A":
                        num = 10;
                        break;
                    case "B":
                        num = 11;
                        break;
                    case "C":
                        num = 12;
                        break;
                    case "D":
                        num = 13;
                        break;
                    case "E":
                        num = 14;
                        break;
                    case "F":
                        num = 15;
                        break;
                }
            }
            sum += num * Math.pow(16, hexadecimal.length - 1 - i);
        }
        System.out.println(sum);
    }
}
