package T07associativeArrays.moreExercise;

import java.util.*;
import java.util.function.Predicate;

public class P04Snowwhitev2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Dwarf> dwarfs = new ArrayList<>();
        Map<String, Integer> hats = new LinkedHashMap<>();
        String input;
        while (!(input = scan.nextLine()).equals("Once upon a time")) {
            String[] info = input.split(" <:> ");
            String name = info[0];
            String hatColour = info[1];
            int physics = Integer.parseInt(info[2]);
            Predicate<Dwarf> sameNameSameHatColor = d -> d.getName().equals(name) && d.getHatColour().equals(hatColour);
            if (dwarfs.stream().anyMatch(sameNameSameHatColor)) {
                Dwarf newDwarf = dwarfs.stream().filter(sameNameSameHatColor).findFirst().get();
                newDwarf.setPhysics(Math.max(newDwarf.getPhysics(), physics));
            } else {
                dwarfs.add(new Dwarf(name, hatColour, physics));
            }

        }
        dwarfs.forEach(d -> {
            hats.putIfAbsent(d.getHatColour(), 0);
            hats.put(d.getHatColour(), hats.get(d.getHatColour()) + 1);
        });

        dwarfs.stream().sorted((f, s) -> {
            int result = Integer.compare(s.getPhysics(), f.getPhysics());
            if (result == 0) {
                result = Integer.compare(hats.get(s.getHatColour()), hats.get(f.getHatColour()));
            }
            return result;
        }).forEach(System.out::println);
    }

    public static class Dwarf {
        private String name;
        private final String hatColour;
        private int physics;

        public Dwarf(String name, String hatColour, int physics) {
            this.name = name;
            this.hatColour = hatColour;
            this.physics = physics;
        }

        public String getName() {
            return name;
        }

        public String getHatColour() {
            return hatColour;
        }

        public int getPhysics() {
            return physics;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("(%s) %s <-> %d", this.hatColour, this.name, this.physics);
        }

        public void setPhysics(int physics) {
            this.physics = physics;
        }
    }


}
