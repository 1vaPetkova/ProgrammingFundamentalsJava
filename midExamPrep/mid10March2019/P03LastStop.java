package midExamPrep.mid10March2019;

import java.util.*;
import java.util.stream.Collectors;

public class P03LastStop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("END")) {
            switch (input.split("\\s+")[0]) {
                case "Change":
                    int paintingToChange = Integer.parseInt(input.split("\\s+")[1]);
                    int changedNumber = Integer.parseInt(input.split("\\s+")[2]);
                    if (doesPaintingExist(paintingToChange, list)) {
                        int indexToChange = list.indexOf(paintingToChange);
                        list.set(indexToChange, changedNumber);
                    }
                    break;
                case "Hide":
                    int paintingToHide = Integer.parseInt(input.split("\\s+")[1]);
                    if (doesPaintingExist(paintingToHide, list)) {
                        list.remove((Integer) paintingToHide);
                    }
                    break;
                case "Switch":
                    int firstPainting = Integer.parseInt(input.split("\\s+")[1]);
                    int secondPainting = Integer.parseInt(input.split("\\s+")[2]);
                    if (doesPaintingExist(firstPainting, list) && doesPaintingExist(secondPainting, list)) {
                        int temp = list.get(list.indexOf(firstPainting));
                        int secondIndex = list.indexOf(secondPainting);
                        list.set(list.indexOf(firstPainting), secondPainting);
                        list.set(secondIndex, temp);
                    }
                    break;
                case "Insert":
                    int place = Integer.parseInt(input.split("\\s+")[1]);
                    int paintingToInsert = Integer.parseInt(input.split("\\s+")[2]);
                    if (place >= 0 && place < list.size()) {
                        list.add(place + 1, paintingToInsert);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(list);
                    break;
            }
        }
        list.forEach(p -> System.out.print(p + " "));
    }


    private static boolean doesPaintingExist(int paintingNumber, List<Integer> list) {
        return list.contains(paintingNumber);
    }
}
