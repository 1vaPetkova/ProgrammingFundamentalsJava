package finalExamPrep.fin04v2;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        int maxHP = 100;
        int maxMP = 200;
        Map<String, Integer> hitPoints = new TreeMap<>();
        Map<String, Integer> manaPoints = new TreeMap<>();
        while (lines-- > 0) {
            String[] info = scan.nextLine().split("\\s+");
            String heroName = info[0];
            int HP = Integer.parseInt(info[1]);
            int MP = Integer.parseInt(info[2]);
            hitPoints.put(heroName, Math.min(HP, maxHP));
            manaPoints.put(heroName, Math.min(MP, maxMP));
        }
        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {
            String[] tokens = input.split(" - ");
            String heroName = tokens[1];
            switch (tokens[0]) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if (manaPoints.get(heroName) >= neededMP) {
                        manaPoints.put(heroName, manaPoints.get(heroName) - neededMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n",
                                heroName, spellName, manaPoints.get(heroName));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!\n",
                                heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    hitPoints.put(heroName, hitPoints.get(heroName) - damage);
                    if (hitPoints.get(heroName) > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",
                                heroName, damage, attacker, hitPoints.get(heroName));
                    } else {
                        hitPoints.remove(heroName);
                        manaPoints.remove(heroName);
                        System.out.printf("%s has been killed by %s!\n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    int currentMP = manaPoints.get(heroName);
                    manaPoints.put(heroName, Math.min(manaPoints.get(heroName) + amount, maxMP));
                    int diff = manaPoints.get(heroName) - currentMP;
                    System.out.printf("%s recharged for %d MP!\n", heroName, diff);
                    break;
                case "Heal":
                    amount = Integer.parseInt(tokens[2]);
                    int currentHP = hitPoints.get(heroName);
                    hitPoints.put(heroName, Math.min(hitPoints.get(heroName) + amount, maxHP));
                    diff = hitPoints.get(heroName) - currentHP;
                    System.out.printf("%s healed for %d HP!\n", heroName, diff);
                    break;
            }
        }
        hitPoints.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.println("  HP: " + e.getValue());
                    System.out.println("  MP: " + manaPoints.get(e.getKey()));
                });
    }
}
