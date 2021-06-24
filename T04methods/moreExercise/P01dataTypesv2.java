package T04methods.moreExercise;

import java.util.Scanner;

public class P01dataTypesv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dataType = scan.nextLine();
        String input = scan.nextLine();
        String output = readDataType(dataType,input);
        System.out.println(output);
    }

    private static String readDataType(String dataType, String input) {
        String output = "";
        switch (dataType){
            case "int":
                output = String.valueOf(Integer.parseInt(input)*2);
                break;
            case "real":
                output = String.valueOf(String.format("%.2f",Double.parseDouble(input)*1.5));
                break;
            case "string":
                output = String.format("$%s$",input);
                break;
        }
        return output;
    }
    }

