package finalExamPrep.fin01;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pieces = Integer.parseInt(scan.nextLine());
        Map<String, String> mapComposer = new TreeMap<>();
        Map<String, String> mapKey = new TreeMap<>();
        for (int i = 0; i < pieces; i++) {
            String text = scan.nextLine();
            String currPiece = text.split("\\|")[0];
            String currComposer = text.split("\\|")[1];
            String currKey = text.split("\\|")[2];

            mapComposer.putIfAbsent(currPiece, "");
            mapComposer.put(currPiece, currComposer);
            mapKey.putIfAbsent(currPiece, "");
            mapKey.put(currPiece, currKey);
        }
        String input = "";
        while (!(input = scan.nextLine()).equals("Stop")) {
            String pieceToAmend = input.split("\\|")[1];

            switch (input.split("\\|")[0]) {
                case "Add":
                    String composerToAmend = input.split("\\|")[2];
                    String keyToAmend = input.split("\\|")[3];
                    if (mapComposer.containsKey(pieceToAmend) && mapKey.containsKey(pieceToAmend)) {
                        System.out.println(pieceToAmend + " is already in the collection!");
                    } else {
                        mapComposer.put(pieceToAmend, composerToAmend);
                        mapKey.put(pieceToAmend, keyToAmend);
                        System.out.printf("%s by %s in %s added to the collection!\n"
                                , pieceToAmend, composerToAmend, keyToAmend);
                    }
                    break;
                case "Remove":
                    if (mapComposer.containsKey(pieceToAmend) && mapKey.containsKey(pieceToAmend)) {
                        mapComposer.remove(pieceToAmend);
                        mapKey.remove(pieceToAmend);
                        System.out.printf("Successfully removed %s!\n", pieceToAmend);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", pieceToAmend);
                    }
                    break;
                case "ChangeKey":
                    String newKey = input.split("\\|")[2];

                    if (mapKey.containsKey(pieceToAmend)) {
                        mapKey.replace(pieceToAmend, mapKey.get(pieceToAmend), newKey);
                        System.out.printf("Changed the key of %s to %s!\n", pieceToAmend, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", pieceToAmend);
                    }
                    break;
            }

        }
        mapComposer.forEach((k, v) -> System.out.printf("%s -> Composer: %s, Key: %s\n", k, v, mapKey.get(k)));
    }
}
