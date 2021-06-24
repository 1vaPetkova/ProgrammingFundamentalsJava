package T05lists.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06listOfProducts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int products = Integer.parseInt(scan.nextLine());
        List<String> productsNames = new ArrayList<>();
        for (int i = 0; i < products; i++) {
          productsNames.add(scan.nextLine());
        }
        Collections.sort(productsNames);
        for (int i = 0; i < productsNames.size(); i++) {
            System.out.printf("%d.%s%n",i+1,productsNames.get(i));
        }
    }
}
