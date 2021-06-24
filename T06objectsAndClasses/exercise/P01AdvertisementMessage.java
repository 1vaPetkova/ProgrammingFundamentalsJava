package T06objectsAndClasses.exercise;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class P01AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        int messages = Integer.parseInt(scan.nextLine());
        Random myRandom = new Random();
        for (int i = 0; i < messages; i++) {
            int randomPhraseIndex = myRandom.nextInt(phrases.length);
            int randomEventIndex = myRandom.nextInt(phrases.length);
            int randomAuthorIndex = myRandom.nextInt(cities.length);
            int randomCityIndex = myRandom.nextInt(cities.length);
            System.out.printf("%s %s %s - %s\n", phrases[randomPhraseIndex], events[randomEventIndex],
                    authors[randomAuthorIndex], cities[randomCityIndex]);
        }
    }
}
