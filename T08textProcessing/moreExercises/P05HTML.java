package T08textProcessing.moreExercises;

import java.util.Scanner;

public class P05HTML {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String h1 = scan.nextLine();
        System.out.println("<h1>\n" + "    " + h1 + "\n" + "</h1>");
        String content = scan.nextLine();
        System.out.println("<article>\n" + "    " + content + "\n" + "</article>");
        String comment = "";

        while (!(comment = scan.nextLine()).equals("end of comments")) {
            System.out.println("<div>\n" + "    " + comment + "\n" + "</div>");
        }
    }
}
