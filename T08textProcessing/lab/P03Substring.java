package T08textProcessing.lab;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstWord = scan.nextLine();
        String secondWord = scan.nextLine();

       while(secondWord.contains(firstWord)){
           secondWord=secondWord.replace(firstWord,"");
       }
        System.out.println(secondWord);
    }
}
