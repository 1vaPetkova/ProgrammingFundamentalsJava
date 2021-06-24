package T06objectsAndClasses.exercise.P04Articles2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Article> articlesList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            Article article = new Article(title, content, author);
            articlesList.add(article);
        }
        String criteria = scan.nextLine();
        switch (criteria) {
            case "title":
                articlesList.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articlesList.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articlesList.sort(Comparator.comparing(Article::getAuthor));
                break;
        }
        for (Article article : articlesList) {
            System.out.println(article);
        }
    }


}

