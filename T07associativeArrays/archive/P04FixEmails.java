package T07associativeArrays.archive;

import java.util.*;

public class P04FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = "";
        Map<String, String> emails = new LinkedHashMap<>();
        while (!(name = scan.nextLine()).equals("stop")) {
            String email = scan.nextLine();
            String emailToLC = email.toLowerCase(Locale.ROOT);
            if (!emailToLC.endsWith("us") && !emailToLC.endsWith("uk")) {
                emails.putIfAbsent(name, email);
            }
        }
        emails.entrySet().stream()
                .forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
    }
}
