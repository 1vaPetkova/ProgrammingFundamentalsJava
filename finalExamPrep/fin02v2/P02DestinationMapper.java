package finalExamPrep.fin02v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([=|\\/])(?<destination>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(scan.nextLine());
        List<String> validDestinations = new ArrayList<>();
        int travelPoints = 0;
        while (matcher.find()) {
            validDestinations.add(matcher.group("destination"));
            travelPoints += matcher.group("destination").length();
        }
        System.out.println("Destinations: " + String.join(", ", validDestinations));
        System.out.println("Travel Points: " + travelPoints);
    }
}
