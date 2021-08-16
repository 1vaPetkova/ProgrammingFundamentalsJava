package finalExamPrep.archive.RetakeExam10Jan2019PartI;

import java.util.Scanner;

public class P01SantasCookies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int batchesNeeded = Integer.parseInt(scan.nextLine());
        int singleCookieGrams = 25;
        int cup = 140;
        int smallSpoon = 10;
        int bigSpoon = 20;
        int cookiesPerBox = 5;
        int totalBoxes = 0;
        while (batchesNeeded-- > 0) {
            int flour = Integer.parseInt(scan.nextLine());
            int sugar = Integer.parseInt(scan.nextLine());
            int cocoa = Integer.parseInt(scan.nextLine());
            int flourCups = flour / cup;
            int sugarSpoons = sugar / bigSpoon;
            int cocoaSpoons = cocoa / smallSpoon;
            int minA = Math.min(flourCups, sugarSpoons);
            int min = Math.min(minA, cocoaSpoons);
            if (flourCups <= 0 || sugarSpoons <= 0 || cocoaSpoons <= 0) {
                System.out.println("Ingredients are not enough for a box of cookies.");
            } else {
                int totalCookiesPerBake = (int) Math.floor((cup + smallSpoon + bigSpoon)) * min / singleCookieGrams;
                int boxes = (int) Math.floor(1.0 * totalCookiesPerBake / cookiesPerBox);
                totalBoxes += boxes;
                System.out.println("Boxes of cookies: " + boxes);
            }
        }
        System.out.println("Total boxes: " + totalBoxes);
    }
}
