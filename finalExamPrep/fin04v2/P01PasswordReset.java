package finalExamPrep.fin04v2;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String txt = scan.nextLine();
        String input = "";
        while (!(input = scan.nextLine()).equals("Done")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "TakeOdd":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < txt.length(); i += 2) {
                        sb.append(txt.charAt(i));
                    }
                    txt = sb.toString();
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    sb = new StringBuilder(txt);
                    sb.replace(index, index + length, "");
                    txt = sb.toString();
                    break;
                case "Substitute":
                    String substring = command[1];
                    String substitute = command[2];
                    if (txt.contains(substring)) {
                        int start = txt.indexOf(substring);
                        txt = txt.replace(substring, substitute);
                    } else {
                        System.out.println("Nothing to replace!");
                        continue;
                    }
                    break;
            }
            System.out.println(txt);
        }
        System.out.println("Your password is: " + txt);
    }
}
