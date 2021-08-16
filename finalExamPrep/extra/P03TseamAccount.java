package finalExamPrep.extra;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03TseamAccount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> games = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("Play!")) {
            String[] tokens = input.split("\\s+");
            String game = tokens[1];
            switch (tokens[0]) {
                case "Install":
                    if (!games.contains(game)) {
                        games.add(game);
                    }
                    break;
                case "Uninstall":
                    games.remove(game);
                    break;
                case "Update":
                    if (games.contains(game)) {
                        games.remove(game);
                        games.add(game);
                    }
                    break;
                case "Expansion":
                    String gameName = game.split("-")[0];
                    game=game.replace('-',':');
                    if (games.contains(gameName)) {
                        games.add(games.indexOf(gameName) + 1, game);
                    }
                    break;
            }
        }
        System.out.println(String.join(" ",games));
    }
}
