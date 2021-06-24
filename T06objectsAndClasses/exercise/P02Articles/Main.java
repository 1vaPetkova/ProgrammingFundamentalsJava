package T06objectsAndClasses.exercise.P02Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        String title = input[0];
        String content = input[1];
        String author = input[2];
        Article article = new Article(title, content, author);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(": ");
            String method = tokens[0];
            String newData = tokens[1];
            switch (method) {
                case "Edit":
                    article.edit(newData);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(newData);
                    break;
                case "Rename":
                    article.rename(newData);
                    break;
            }
        }
        System.out.println(article);
    }
}
