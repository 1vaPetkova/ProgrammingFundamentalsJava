package finalExamPrep.extra;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Pattern pattern = Pattern.compile("^(?<peak>[A-Za-z0-9!@#$?]+)=(?<length>\\d+)<<(?<geohash>.*)$");
        while (!(input = scan.nextLine()).equals("Last note")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                int geohashLength = Integer.parseInt(matcher.group("length"));
                if (matcher.group("geohash").length() == geohashLength) {
                    String peakName = matcher.group("peak").replaceAll("[!@#$?]", "");
                    System.out.printf("Coordinates found! %s -> %s\n", peakName, matcher.group("geohash"));
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }
        }
    }
}
