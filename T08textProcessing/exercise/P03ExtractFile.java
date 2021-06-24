package T08textProcessing.exercise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        int nameStart = path.lastIndexOf('\\') + 1;
        int pointIndex = path.indexOf('.');
        System.out.printf("File name: %s\n", path.substring(nameStart,pointIndex));
        System.out.printf("File extension: %s",path.substring(pointIndex+1));
    }
}
