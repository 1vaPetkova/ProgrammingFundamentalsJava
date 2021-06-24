package T09regularExpressions.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\+359([- ])2\\1\\d{3}\\1\\d{4}\\b");
        String phones = scan.nextLine();
        Matcher matcher = pattern.matcher(phones);

        List<String> matchedPhones = new ArrayList<>();
        while(matcher.find()){
            matchedPhones.add(matcher.group());
        }
        System.out.println(matchedPhones.toString().replaceAll("[\\]\\[]",""));
    }
}
