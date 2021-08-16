package finalExamPrep.extra;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class P01CharityMarathon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int runners = Integer.parseInt(scan.nextLine());
        int averageLapsPerRunner = Integer.parseInt(scan.nextLine());
        int trackLength = Integer.parseInt(scan.nextLine());
        int trackCapacity = Integer.parseInt(scan.nextLine());
        BigDecimal moneyPerKm = new BigDecimal(scan.nextLine());


        if ((trackCapacity * days) < runners) {
            runners = trackCapacity*days;
        }
        BigInteger m = BigInteger.valueOf(runners*averageLapsPerRunner);
        m = m.multiply(BigInteger.valueOf(trackLength));

        BigInteger km = m.divide(BigInteger.valueOf(1000));

        BigDecimal moneyRaised = new BigDecimal(km);
        moneyRaised = moneyRaised.multiply(moneyPerKm);

        System.out.printf("Money raised: %.2f", moneyRaised);
    }
}
