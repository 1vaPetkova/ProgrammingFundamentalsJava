package T02dataTypesAndVariables.moreExercises;

import java.util.Scanner;

public class P05decryptingMessagev2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      int key = Integer.parseInt(scan.nextLine());
      int n = Integer.parseInt(scan.nextLine());
      StringBuilder message = new StringBuilder();
      while(n-->0){
          char ch = scan.nextLine().charAt(0);
          message.append((char)(ch+key));
      }
        System.out.println(message);
    }
}
