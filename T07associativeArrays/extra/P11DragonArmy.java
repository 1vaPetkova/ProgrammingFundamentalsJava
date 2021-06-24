package T07associativeArrays.archive;

import java.util.*;

public class P11DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());
        Map<String, Map<String, Integer[]>> types = new LinkedHashMap<>();

        for (int i = 0; i < inputs; i++) {
            String[] token = scan.nextLine().split(" ");
            String type = token[0];
            String name = token[1];

            int damage = token[2].equals("null") ? 45 : Integer.parseInt(token[2]);
            int health = token[3].equals("null") ? 250 : Integer.parseInt(token[3]);
            int armor = token[4].equals("null") ? 10 : Integer.parseInt(token[4]);

            types.putIfAbsent(type, new TreeMap<>());
            types.get(type).putIfAbsent(name, new Integer[3]);
            types.get(type).get(name)[0] = damage;
            types.get(type).get(name)[1] = health;
            types.get(type).get(name)[2] = armor;
        }
            for (Map.Entry<String, Map<String, Integer[]>> entry : types.entrySet()) {
                double sumDamage = 0;
                double sumHealth = 0;
                double sumArmor = 0;
                for (Map.Entry<String, Integer[]> parameters : entry.getValue().entrySet()) {
                    sumDamage += parameters.getValue()[0];
                    sumHealth += parameters.getValue()[1];
                    sumArmor += parameters.getValue()[2];
                }
                double avgDamage = sumDamage / entry.getValue().size();
                double avgHealth = sumHealth / entry.getValue().size();
                double avgArmor = sumArmor / entry.getValue().size();

                System.out.printf("%s::(%.2f/%.2f/%.2f)\n", entry.getKey(), avgDamage, avgHealth, avgArmor);
                entry.getValue().forEach((key, value) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                        key, value[0], value[1], value[2]));
            }

    }
}
