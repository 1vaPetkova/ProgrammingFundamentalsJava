package finalExamPrep.extra;

import java.util.*;

public class P04PokemonEvolution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, List<String>> pokemons = new LinkedHashMap();

        String input = "";
        while (!(input = scan.nextLine()).equals("wubbalubbadubdub")) {
            if (input.contains("->")) {
                String[] tokens = input.split(" -> ");
                String pokemonName = tokens[0];
                String evolution = tokens[1] + " <-> " + tokens[2];
                pokemons.putIfAbsent(pokemonName, new ArrayList<>());
                pokemons.get(pokemonName).add(evolution);
            } else {
                if (pokemons.containsKey(input)) {
                    printCurrentPokemon(pokemons, input);
                }
            }
        }

        for (String name : pokemons.keySet()) {
            printAllPokemon(pokemons, name);
        }
    }

    private static void printAllPokemon(LinkedHashMap<String, List<String>> pokemons, String name) {
        System.out.println("# " + name);

        pokemons.get(name).stream().sorted((a, b) -> {

            String[] evolutionInfoA = a.split(" <-> ");
            int indexA = Integer.parseInt(evolutionInfoA[1]);

            String[] evolutionInfoB = b.split(" <-> ");
            int indexB = Integer.parseInt(evolutionInfoB[1]);

            return Integer.compare(indexB, indexA);
        }).forEach(p -> {
            String[] evolution = p.split(" <-> ");
            String type = evolution[0];
            int index = Integer.parseInt(evolution[1]);
            System.out.println(type + " <-> " + index);
        });
    }

    private static void printCurrentPokemon(LinkedHashMap<String, List<String>> pokemons, String name) {
        System.out.println("# " + name);
        pokemons.get(name).forEach(e -> {
            String[] evolutionInfo = e.split(" <-> ");
            String type = evolutionInfo[0];
            int index = Integer.parseInt(evolutionInfo[1]);
            System.out.println(type + " <-> " + index);
        });
    }
}
