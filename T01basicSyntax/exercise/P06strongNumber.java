package T01basicSyntax.exercise;

import java.util.Scanner;

public class P06strongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        int sumFact = 0;
        int currentNumber = number;
        while (currentNumber > 0) {
            //1. да вземем последната цифра
            int lastDigit = currentNumber % 10;
            int fact = 1;
            //2. да намерим факториела
            for (int i = lastDigit; i > 1; i--) {
                fact *= i;
            }
            //3. да сумираме факториелите
            sumFact += fact;
            //премахваме последната цифра
            currentNumber /= 10;
        }
            //4. проверка дали числото == сума
        if (sumFact == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
