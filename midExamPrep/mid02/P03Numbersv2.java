package midExamPrep.mid02;

import java.util.*;
import java.util.stream.Collectors;

public class P03Numbersv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        double averageNumber = 1.0 * sum / list.size();
        List<Integer> topList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)>averageNumber){
                topList.add(list.get(i));
            }
        }
        topList.sort(Collections.reverseOrder());
        if (topList.size() > 5) {
            for (int i = 5; i < topList.size(); i++) {
                topList.remove(i);
                i--;
            }
        }
        if(topList.isEmpty()){
            System.out.println("No");
        } else{
            System.out.println(topList.toString().replaceAll("[\\[\\],]",""));
        }
    }
}

