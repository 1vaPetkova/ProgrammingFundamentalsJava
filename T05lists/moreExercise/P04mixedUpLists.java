package T05lists.moreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P04mixedUpLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> mixedList = new ArrayList<>();
        int minSize = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < 2 * minSize; i++) {
            if (i % 2 == 0) {
                mixedList.add(firstList.get(0));
                firstList.remove(0);
            } else {
                mixedList.add(secondList.get(secondList.size() - 1));
                secondList.remove(secondList.size() - 1);
            }
        }
        int minBorder = 0;
        int maxBorder = 0;
        if (firstList.isEmpty()) {
            minBorder = Math.min(secondList.get(0), secondList.get(1));
            maxBorder = Math.max(secondList.get(0), secondList.get(1));
        } else if (secondList.isEmpty()) {
            minBorder = Math.min(firstList.get(0), firstList.get(1));
            maxBorder = Math.max(firstList.get(0), firstList.get(1));
        }

        for (int i = 0; i < mixedList.size(); i++) {
            if (mixedList.get(i) <= minBorder || mixedList.get(i) >= maxBorder) {
                mixedList.remove(i);
                i--;
            }
        }
        Collections.sort(mixedList);
        System.out.println(mixedList.toString().replaceAll("[\\[\\],]", ""));
    }
}

