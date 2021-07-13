package midExam20210710;

import java.util.*;
import java.util.stream.Collectors;

public class P03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split(":"))
                .collect(Collectors.toList());
        List<String> deck = new ArrayList<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("Ready")) {

            switch (input.split("\\s+")[0]) {
                case "Add":
                    String cardToAdd = input.split("\\s+")[1];
                    if (!list.contains(cardToAdd)) {
                        System.out.println("Card not found.");
                    } else {
                        deck.add(cardToAdd);
                    }
                    break;
                case "Insert":
                    String cardToInsert = input.split("\\s+")[1];
                    int index = Integer.parseInt(input.split("\\s+")[2]);
                    if (!list.contains(cardToInsert) || !isValid(index, deck)) {
                        System.out.println("Error!");
                    } else {
                        deck.add(index, cardToInsert);
                    }
                    break;
                case "Remove":
                    String cardToRemove = input.split("\\s+")[1];
                    if (deck.contains(cardToRemove)) {
                        deck.remove(cardToRemove);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    String firstCard = input.split("\\s+")[1];
                    String secondCard = input.split("\\s+")[2];
                    int firstIndex = deck.indexOf(firstCard);
                    int secondIndex = deck.indexOf(secondCard);
                    deck.set(firstIndex, secondCard);
                    deck.set(secondIndex, firstCard);
                    break;
                case "Shuffle":
                    Collections.reverse(deck);
                    break;
            }
        }
        System.out.println(String.join(" ", deck));

    }

    private static boolean isValid(int index, List<String> cards) {
        return index >= 0 && index < cards.size();
    }
}
