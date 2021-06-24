package T09regularExpressions.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P05NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //!!!! there might be spaces before or after the comma
        List<String> demons = Arrays.stream(scan.nextLine().trim().split("\\s*,+\\s*"))
                .collect(Collectors.toList());
        Collections.sort(demons);
        for (int i = 0; i < demons.size(); i++) {
            //health
            Pattern patternHealth = Pattern.compile("(?:[^0-9+\\-*\\/.])");
            Matcher matcherHealth = patternHealth.matcher(demons.get(i));
            int health = 0;
                while (matcherHealth.find()) {
                    health += matcherHealth.group().charAt(0);
                }
            //damage
            Pattern patternDamage = Pattern.compile("[+-]?\\d+\\.?\\d*");
            Matcher matcherDamage = patternDamage.matcher(demons.get(i));
            double damage = 0;
            while (matcherDamage.find()) {
                damage += Double.parseDouble(matcherDamage.group(0));
            }
            Pattern patternAlteration = Pattern.compile("[*\\/]");
            Matcher matcherAlteration = patternAlteration.matcher(demons.get(i));
            while (matcherAlteration.find()) {
                if (matcherAlteration.group(0).equals("*")) {
                    damage *= 2;
                } else if (matcherAlteration.group(0).equals("/")){
                    damage /= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage\n",demons.get(i),health,damage);
        }
    }
}
