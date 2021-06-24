package T08textProcessing.moreExercises;

import java.util.Scanner;

public class P01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < lines; i++) {
            String input = scan.nextLine();
            int nameFirstIndex = input.indexOf("@")+1;
            int nameLastIndex = input.indexOf("|");
            output.append(input.substring(nameFirstIndex,nameLastIndex));
            output.append(" is ");
            int ageFirstIndex = input.indexOf("#")+1;
            int ageLastIndex = input.indexOf("*");
            output.append(input.substring(ageFirstIndex,ageLastIndex));
            output.append(" years old.");
            System.out.println(output);
            output.setLength(0);
        }
    }
}
