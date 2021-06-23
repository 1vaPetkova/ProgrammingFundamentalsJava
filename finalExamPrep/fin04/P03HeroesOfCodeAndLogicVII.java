package finalExamPrep.fin04;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfHeroes = Integer.parseInt(scan.nextLine());
        Map<String, Integer> hit = new TreeMap<>();
        Map<String, Integer> mana = new TreeMap<>();
        for (int i = 0; i < numberOfHeroes; i++) {
            String text = scan.nextLine();
            String name = text.split("\\s+")[0];
            int hitPoints = Integer.parseInt(text.split("\\s+")[1]);
            int manaPoints = Integer.parseInt(text.split("\\s+")[2]);
            hit.putIfAbsent(name, 0);
            hit.put(name, hitPoints);
            mana.putIfAbsent(name, 0);
            mana.put(name, manaPoints);
        }
        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {
            String heroName = input.split("\\s+-\\s+")[1];
            switch (input.split("\\s+-\\s+")[0]) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(input.split("\\s+-\\s+")[2]);
                    String spellName = input.split("\\s+-\\s+")[3];
                    if (mana.get(heroName) >= mpNeeded) {
                        int newMana = mana.get(heroName) - mpNeeded;
                        mana.put(heroName, newMana);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n", heroName, spellName, newMana);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!\n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(input.split("\\s+-\\s+")[2]);
                    String attacker = input.split("\\s+-\\s+")[3];
                    hit.put(heroName, hit.get(heroName) - damage);
                    if (hit.get(heroName) > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",
                                heroName, damage, attacker, hit.get(heroName));
                    } else {
                        System.out.printf("%s has been killed by %s!\n", heroName, attacker);
                        mana.remove(heroName);
                        hit.remove(heroName);

                    }
                    break;
                case "Recharge":
                    int amountMP = Integer.parseInt(input.split("\\s+-\\s+")[2]);
                    int newMP = Math.min(mana.get(heroName) + amountMP, 200);
                    int diffMP = newMP - mana.get(heroName);
                    mana.put(heroName, Math.min(mana.get(heroName) + amountMP, 200));
                    System.out.printf("%s recharged for %d MP!\n", heroName, diffMP);
                    break;
                case "Heal":
                    int amountHP = Integer.parseInt(input.split("\\s+-\\s+")[2]);
                    int newHP = Math.min(hit.get(heroName) + amountHP, 100);
                    int diffHP = newHP - hit.get(heroName);
                    hit.put(heroName, newHP);
                    System.out.printf("%s healed for %d HP!\n", heroName, diffHP);
                    break;
            }
        }
        hit.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.println("  HP: " + e.getValue());
                    System.out.println("  MP: " + mana.get(e.getKey()));
                });
    }
}
