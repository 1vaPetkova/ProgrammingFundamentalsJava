package T07associativeArrays.archive;

import java.util.*;

public class P11DragonArmyv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());
        Map<String, List<P11Dragon>> register = new LinkedHashMap<>();

        for (int i = 0; i < inputs; i++) {
            String[] token = scan.nextLine().split(" ");
            String type = token[0];
            String name = token[1];

            int damage = token[2].equals("null") ? 45 : Integer.parseInt(token[2]);
            int health = token[3].equals("null") ? 250 : Integer.parseInt(token[3]);
            int armor = token[4].equals("null") ? 10 : Integer.parseInt(token[4]);

            P11Dragon currentP11Dragon = new P11Dragon(name, damage, health, armor);

            if (!register.containsKey(type)) {
                register.put(type, new ArrayList<>());
                register.get(type).add(currentP11Dragon);
            } else {
                boolean hasName = register.get(type).stream().anyMatch(s -> s.getName().equals(name));

                if (register.containsKey(type) & hasName) {
                    for (P11Dragon p11Dragon : register.get(type)) {
                        if (p11Dragon.getName().equals(name)) {
                            register.get(type).remove(p11Dragon);
                            break;
                        }
                    }
                }
                register.get(type).add(currentP11Dragon);
            }
        }
        register.entrySet().stream().forEach(type -> {
            int size = type.getValue().size();

            final double[] averageDamage = { 0 };
            type.getValue().stream().forEach(p11Dragon -> {
                averageDamage[0] += p11Dragon.getDamage();
            });
            averageDamage[0] /= size;

            final double[] averageHealth = { 0 };
            type.getValue().stream().forEach(p11Dragon -> {
                averageHealth[0] += p11Dragon.getHealth();
            });
            averageHealth[0] /= size;

            final double[] averageArmor = { 0 };
            type.getValue().stream().forEach(p11Dragon -> {
                averageArmor[0] += p11Dragon.getArmor();
            });
            averageArmor[0] /= size;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(), averageDamage[0], averageHealth[0],
                    averageArmor[0]);

            // PRINT EACH DRAGON
            type.getValue().stream().sorted(Comparator.comparing(P11Dragon::getName)).forEach(p11Dragon -> {

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", p11Dragon.getName(), p11Dragon.getDamage(),
                        p11Dragon.getHealth(), p11Dragon.getArmor());
            });
        });
    }
}
