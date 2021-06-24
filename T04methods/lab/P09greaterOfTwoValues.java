package T04methods.lab;

import java.util.Scanner;

public class P09greaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        String firstValue = scan.nextLine();
        String secondValue = scan.nextLine();
        String maxValue = getMax(type, firstValue, secondValue);
        System.out.println(maxValue);

    }

    private static String getMax(String type, String firstValue, String secondValue) {
        String maxValue = "";
        switch (type) {
            case "int":
                maxValue = String.valueOf(Math.max(Integer.parseInt(firstValue), Integer.parseInt(secondValue)));
                break;
            case "char":
                maxValue = String.format("%c", Math.max(firstValue.charAt(0), secondValue.charAt(0)));
                break;
            case "string":
                if (firstValue.compareTo(secondValue) > 0) {
                    maxValue = firstValue;
                } else {
                    maxValue = secondValue;
                }
        }
        return maxValue;
    }
}
