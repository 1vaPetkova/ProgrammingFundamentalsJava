package T07associativeArrays.archive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P01Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = "";
        Map<String, String> phonebook = new HashMap<>();
        while (!(input = scan.nextLine()).equals("END")) {
            String command = input.split(" ")[0];
            String name = input.split(" ")[1];
            switch (command) {
                case "A":
                    String number = input.split(" ")[2];
                    phonebook.putIfAbsent(name, "");
                    phonebook.put(name, number);
                    break;
                case "S":
                    if (phonebook.containsKey(name)) {
                        System.out.printf("%s -> %s\n", name, phonebook.get(name));
                    } else {
                        System.out.printf("Contact %s does not exist.\n", name);
                    }
                    break;
            }
        }
    }
}
