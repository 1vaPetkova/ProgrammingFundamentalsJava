package finalExamPrep.fin01v2;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        Map<String, String> composers = new TreeMap<>();
        Map<String, String> keys = new TreeMap<>();
        while (lines-- > 0) {
            String[] info = scan.nextLine().split("\\|");
            String piece = info[0];
            String composer = info[1];
            String key = info[2];
            composers.put(piece, composer);
            keys.put(piece, key);
        }

        String input = "";
        while (!(input = scan.nextLine()).equals("Stop")) {
            String[] commands = input.split("\\|");
            String piece = commands[1];
            switch (commands[0]) {
                case "Add":
                    if (composers.containsKey(piece)) {
                        System.out.println(piece + " is already in the collection!");
                    } else {
                        composers.put(piece, commands[2]);
                        keys.put(piece, commands[3]);
                        System.out.printf("%s by %s in %s added to the collection!\n",
                                piece, composers.get(piece), keys.get(piece));
                    }
                    break;
                case "Remove":
                    if (composers.containsKey(piece)) {
                        composers.remove(piece);
                        keys.remove(piece);
                        System.out.printf("Successfully removed %s!\n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                    }
                    break;
                case "ChangeKey":
                    if (composers.containsKey(piece)) {
                        keys.put(piece, commands[2]);
                        System.out.printf("Changed the key of %s to %s!\n", piece, commands[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                    }
                    break;
            }
        }
        composers.forEach((key, value) -> System.out.printf("%s -> Composer: %s, Key: %s\n",
                key, value, keys.get(key)));
    }
}
