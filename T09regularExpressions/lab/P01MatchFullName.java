package T09regularExpressions.lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01MatchFullName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\b(?<firstName>[A-Z][a-z]+) (?<secondName>[A-Z][a-z]+)\\b");
        String listOfNames = scan.nextLine();
        Matcher matcher = pattern.matcher(listOfNames);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
