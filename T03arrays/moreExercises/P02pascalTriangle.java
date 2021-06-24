package T03arrays.moreExercises;

import java.util.Scanner;

public class P02pascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long countRows = Integer.parseInt(scan.nextLine());

        long[] tempArray = {1, 1};
        for (int rows = 1; rows <= countRows; rows++) {
            long[] newArray = new long[rows];
            newArray[0] = 1;
            newArray[newArray.length - 1] = 1;

            if (rows > 2) {
                for (int i = 1; i < newArray.length - 1; i++) {
                    newArray[i] = tempArray[i - 1] + tempArray[i];
                }
            }
            //the newArray becomes the tempArray for the next row

            tempArray = newArray;
            //Printing the new array

            for (int j = 0; j < newArray.length - 1; j++) {
                System.out.print(newArray[j] + " ");
            }
            System.out.println(newArray[newArray.length - 1]);
        }
    }
}







