package finalExamPrep.fin04;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String commands = "";
        StringBuilder password = new StringBuilder(scan.nextLine());
        while (!(commands = scan.nextLine()).equals("Done")) {
            switch (commands.split("\\s")[0]) {
                case "TakeOdd":
                    //This might not be the first command!!!!!!!!!!!!!!!!!!!!
                    StringBuilder newPass = new StringBuilder();
                    for (int i = 1; i < password.length(); i += 2) {
                        newPass.append(password.charAt(i));
                    }
                    password = new StringBuilder(newPass);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commands.split("\\s")[1]);
                    int length = Integer.parseInt(commands.split("\\s")[2]);
                    String cutted = password.substring(index, index + length);
                    password.delete(password.indexOf(cutted), password.indexOf(cutted) + length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = commands.split("\\s")[1];
                    String substitute = commands.split("\\s")[2];
                    if (password.toString().contains(substring)) {
                        password = new StringBuilder(password.toString().replace(substring, substitute));
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
        }
        System.out.println("Your password is: " + password);
    }
}
