package T09regularExpressions.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("(?<user>[A-Za-z0-9]+[\\.\\-\\_]*[A-Za-z0-9]+)@" +
                "(?<host>[A-Za-z]+[\\.\\-\\_]*[A-Za-z]+(\\.\\w+)+)");
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
