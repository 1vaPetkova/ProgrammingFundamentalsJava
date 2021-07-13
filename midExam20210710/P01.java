package midExam20210710;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double food = Double.parseDouble(scan.nextLine());
        double hay = Double.parseDouble(scan.nextLine());
        double cover = Double.parseDouble(scan.nextLine());
        double weight = Double.parseDouble(scan.nextLine());

        double foodInGrams = food * 1000;
        double hayInGrams = hay * 1000;
        double coverInGrams = cover * 1000;
        double weightInGrams = weight * 1000;
        double weightForCover = weightInGrams/3;
        for (int i = 1; i <= 30; i++) {
            foodInGrams -= 300;
            if (foodInGrams <= 0) {
                break;
            }
            if (i % 2 == 0) {
                hayInGrams -= 0.05 * foodInGrams;
                if (hayInGrams <= 0) {
                    break;
                }
            }
            if (i % 3 == 0) {
                coverInGrams -= weightForCover;
                if (coverInGrams <= 0) {
                    break;
                }
            }
        }

        if (foodInGrams <= 0 || hayInGrams <= 0 || coverInGrams <= 0) {
            System.out.println("Merry must go to the pet store!");
        } else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    foodInGrams/1000, hayInGrams/1000, coverInGrams/1000);
        }
    }
}
