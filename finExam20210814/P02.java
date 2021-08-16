package finExam20210814;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        Pattern pattern = Pattern.compile("^(\\|(?<boss>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+\\s[A-Za-z]+)#)$");
        while (lines-- > 0) {
            String txt = scan.nextLine();
            Matcher matcher = pattern.matcher(txt);
            if (matcher.find()) {
                String bossName = matcher.group("boss");
                String title = matcher.group("title");
                int strength = bossName.length();
                int armor = title.length();
                System.out.printf("%s, The %s\n", bossName, title);
                System.out.println(">> Strength: " + strength);
                System.out.println(">> Armor: " + armor);
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}
