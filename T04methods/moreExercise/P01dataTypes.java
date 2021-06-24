package T04methods.moreExercise;

import java.util.Scanner;

public class P01dataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dataType = scan.nextLine();
        String input = scan.nextLine();
        String output = "";
        switch (dataType){
            case "int":
                output = readInteger(input);
                break;
            case "real":
                output = readRealNumber(input);
                break;
            case "string":
                output = readString(input);
                break;
        }
        System.out.println(output);
    }

    private static String readString(String input) {
        return String.format("$%s$",input);
    }

    private static String readRealNumber(String input) {
        return String.valueOf(String.format("%.2f",Double.parseDouble(input)*1.5));
    }

    private static String readInteger(String input) {
        return String.valueOf(Integer.parseInt(input)*2);
    }
}
