package T08textProcessing.archive;

import java.util.Scanner;

public class P09MelrahShake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder txt = new StringBuilder(scan.nextLine());
        StringBuilder pattern = new StringBuilder(scan.nextLine());

        while (true) {
            int firstIndex = txt.indexOf(pattern.toString());
            int lastIndex = txt.lastIndexOf(pattern.toString());
            if (firstIndex == -1 || lastIndex == -1 || firstIndex == lastIndex || pattern.length()==0) {
                System.out.println("No shake.");
                System.out.println(txt);
                break;
            }
            txt.delete(firstIndex, firstIndex + pattern.length());
            txt.delete(lastIndex - pattern.length(), lastIndex);
            txt = new StringBuilder(txt);
            int middleIndex = pattern.length() / 2;
            pattern = new StringBuilder(pattern.deleteCharAt(middleIndex));
            System.out.println("Shaked it.");
        }
    }
}
