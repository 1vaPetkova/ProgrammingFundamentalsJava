package midExamPrep.mid06_retakeMarch2018;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02SantasList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("&"))
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("Finished!")) {
            String[] token = input.split(" ");
            String kidName = token[1];
            switch (token[0]) {
                case "Bad":
                    if (!list.contains(kidName)) {
                        list.add(0, kidName);
                    }
                    break;
                case "Good":
                    list.remove(kidName);
                    break;
                case "Rename":
                    String newName = token[2];
                    if (list.contains(kidName)) {
                        list.set(list.indexOf(kidName), newName);
                    }
                    break;
                case "Rearrange":
                    if (list.contains(kidName)) {
                        list.remove(kidName);
                        list.add(kidName);
                    }
                    break;
            }
        }
        System.out.println(String.join(", ",list));
    }
}
