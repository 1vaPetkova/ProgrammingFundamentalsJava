package finalExamPrep.extra;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03HornetAssault {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Long> beehives = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<Long> hornets = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        for (int i = 0; i < beehives.size(); i++) {
            long hornetsSum = hornets.stream().mapToLong(e -> e).sum();
            if (beehives.get(i) >= hornetsSum) {
                hornets.remove(0);
                beehives.set(i, beehives.get(i) - hornetsSum);
                if (beehives.get(i) == 0) {
                    beehives.remove(i);
                    i--;
                }
            } else {
                beehives.remove(i);
                i--;
            }
            if (hornets.isEmpty()) {
                break;
            }
        }
        if (!beehives.isEmpty()) {
            beehives.forEach(b -> System.out.print(b + " "));
        } else {
            hornets.forEach(h -> System.out.print(h + " "));
        }
    }
}
