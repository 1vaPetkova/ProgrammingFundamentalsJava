package T07associativeArrays.archive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = "";
        Map<String, String> phonebook = new TreeMap<>();
        while (!(input = scan.nextLine()).equals("END")) {
            String command = input.split(" ")[0];
            String name = "";
            switch (command) {
                case "A":
                    name = input.split(" ")[1];
                    String number = input.split(" ")[2];
                    phonebook.putIfAbsent(name, "");
                    phonebook.put(name, number);
                    break;
                case "S":
                    name = input.split(" ")[1];
                    if (phonebook.containsKey(name)) {
                        System.out.printf("%s -> %s\n", name, phonebook.get(name));
                    } else {
                        System.out.printf("Contact %s does not exist.\n", name);
                    }
                    break;
                case "ListAll":
                    phonebook.entrySet()
                            .forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
                    break;
            }
        }
    }
}
