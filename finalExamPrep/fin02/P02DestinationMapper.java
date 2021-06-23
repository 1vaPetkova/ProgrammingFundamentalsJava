package finalExamPrep.fin02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("(=|\\/)([A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> destinations = new ArrayList<>();

        while(matcher.find()){
            destinations.add(matcher.group(2));
        }

        int travelPoints = destinations.stream().mapToInt(String::length).sum();
        System.out.println("Destinations: "+ destinations.toString().replaceAll("[\\[\\]]",""));
        System.out.println("Travel Points: "+travelPoints);
    }
}
