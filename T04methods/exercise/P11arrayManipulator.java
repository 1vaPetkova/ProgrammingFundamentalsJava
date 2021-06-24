package T04methods.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11arrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = "";
        while (!(input = scan.nextLine()).equals("end")) {
            String command[] = input.split(" ");
            String type = command[0];
            String output = "";
            switch (type) {
                case "exchange":
                    int index = Integer.parseInt(command[1]);
                    if (index == array.length - 1) {
                        continue;
                    }
                    if (validateIndex(index, array.length)) {
                        //exchanged array becomes the new array
                        array = getExchangedArray(index, array);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    if (command[1].equals("even")) {
                        printMaxEvenElementIndex(array);
                    } else if (command[1].equals("odd")) {
                        printMaxOddElementIndex(array);
                    }
                    break;
                case "min":
                    if (command[1].equals("even")) {
                        printMinEvenElementIndex(array);
                    } else if (command[1].equals("odd")) {
                        printMinOddElementIndex(array);
                    }
                    break;
                case "first":
                    int countFirst = Integer.parseInt(command[1]);
                    if (validateCount(countFirst, array.length)) {
                        if (command[2].equals("even")) {
                            printFirstEvenNumbers(countFirst, array);
                        } else if (command[2].equals("odd")) {
                            printFirstOddNumbers(countFirst, array);
                        }
                    } else {
                        System.out.println("Invalid count");
                    }
                    break;
                case "last":
                    int countLast = Integer.parseInt(command[1]);
                    if (validateCount(countLast, array.length)) {
                        if (command[2].equals("even")) {
                            printLastEvenNumbers(countLast, array);
                        } else if (command[2].equals("odd")) {
                            printLastOddNumbers(countLast, array);
                        }
                    } else {
                        System.out.println("Invalid count");
                    }
                    break;
            }
        }
        String[] arrayText = new String[array.length];
        for (int k = 0; k < arrayText.length; k++) {
            arrayText[k] = String.valueOf(array[k]);
        }
        String output = String.join(", ", arrayText);
        System.out.printf("[%s]\n", output);
    }

    private static void printLastOddNumbers(int countLast, int[] array) {
        int countOdd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                countOdd++;
            }
        }
        int[] lastOddReversed = new int[Math.min(countLast, countOdd)];
        int lastOddIndex = 0;
        //We receive the numbers in reversed order!
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 != 0) {
                lastOddReversed[lastOddIndex] = array[i];
                lastOddIndex++;
            }
            if (lastOddIndex > lastOddReversed.length - 1) {
                break;
            }
        }
        //We need to reverse the array
        int[] lastOdd = new int[lastOddReversed.length];
        for (int i = 0; i < lastOdd.length; i++) {
            lastOdd[i] = lastOddReversed[lastOddReversed.length - 1 - i];
        }
        if (countOdd == 0) {
            System.out.println("[]");
        } else {
            String[] firstOddOutput = new String[lastOdd.length];
            for (int k = 0; k < lastOdd.length; k++) {
                firstOddOutput[k] = String.valueOf(lastOdd[k]);
            }
            String output = String.join(", ", firstOddOutput);
            System.out.printf("[%s]\n", output);
        }
    }

    private static void printLastEvenNumbers(int countLast, int[] array) {
        int countEven = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                countEven++;
            }
        }
        int[] lastEvenReversed = new int[Math.min(countLast, countEven)];
        int lastEvenIndex = 0;
        //We receive the numbers in reversed order!
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0) {
                lastEvenReversed[lastEvenIndex] = array[i];
                lastEvenIndex++;
            }
            if (lastEvenIndex > lastEvenReversed.length - 1) {
                break;
            }
        }
        //We need to reverse the array
        int[] lastEven = new int[lastEvenReversed.length];
        for (int i = 0; i < lastEven.length; i++) {
            lastEven[i] = lastEvenReversed[lastEvenReversed.length - 1 - i];
        }
        if (countEven == 0) {
            System.out.println("[]");
        } else {
            String[] firstOddOutput = new String[lastEven.length];
            for (int k = 0; k < lastEven.length; k++) {
                firstOddOutput[k] = String.valueOf(lastEven[k]);
            }
            String output = String.join(", ", firstOddOutput);
            System.out.printf("[%s]\n", output);
        }
    }

    private static void printFirstOddNumbers(int countFirst, int[] array) {
        int countOdd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                countOdd++;
            }
        }
        int[] firstOdd = new int[Math.min(countFirst, countOdd)];
        int firstOddIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                firstOdd[firstOddIndex] = array[i];
                firstOddIndex++;
            }
            if (firstOddIndex > firstOdd.length - 1) {
                break;
            }
        }
        if (countOdd == 0) {
            System.out.println("[]");
        } else {
            String[] firstOddOutput = new String[firstOdd.length];
            for (int k = 0; k < firstOdd.length; k++) {
                firstOddOutput[k] = String.valueOf(firstOdd[k]);
            }
            String output = String.join(", ", firstOddOutput);
            System.out.printf("[%s]\n", output);
        }
    }

    private static void printFirstEvenNumbers(int countFirst, int[] array) {
        int countEven = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                countEven++;
            }
        }
        int[] firstEven = new int[Math.min(countFirst, countEven)];
        int firstEvenIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                firstEven[firstEvenIndex] = array[i];
                firstEvenIndex++;
            }
            if (firstEvenIndex > firstEven.length - 1) {
                break;
            }
        }
        if (countEven == 0) {
            System.out.println("[]");
        } else {
            String[] firstOddOutput = new String[firstEven.length];
            for (int k = 0; k < firstEven.length; k++) {
                firstOddOutput[k] = String.valueOf(firstEven[k]);
            }
            String output = String.join(", ", firstOddOutput);
            System.out.printf("[%s]\n", output);
        }
    }


    private static void printMinOddElementIndex(int[] array) {
        int minOdd = Integer.MAX_VALUE;
        int minOddNumberIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] <= minOdd) {
                minOdd = array[i];
                minOddNumberIndex = i;
            }
        }
        if (minOdd == Integer.MAX_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(minOddNumberIndex);
        }
    }

    private static void printMinEvenElementIndex(int[] array) {
        int minEven = Integer.MAX_VALUE;
        int minEvenNumberIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] <= minEven) {
                minEven = array[i];
                minEvenNumberIndex = i;
            }
        }
        if (minEven == Integer.MAX_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(minEvenNumberIndex);
        }
    }

    private static void printMaxOddElementIndex(int[] array) {
        int maxOdd = Integer.MIN_VALUE;
        int maxOddNumberIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] >= maxOdd) {
                maxOdd = array[i];
                maxOddNumberIndex = i;
            }
        }
        if (maxOdd == Integer.MIN_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(maxOddNumberIndex);
        }
    }

    private static void printMaxEvenElementIndex(int[] array) {
        int maxEven = Integer.MIN_VALUE;
        int maxEvenNumberIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] >= maxEven) {
                maxEven = array[i];
                maxEvenNumberIndex = i;
            }
        }
        if (maxEven == Integer.MIN_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(maxEvenNumberIndex);
        }
    }

    private static int[] getExchangedArray(int index, int[] array) {
        int[] exchangedArray = new int[array.length];
        int rightPartLength = array.length - index - 1;//goes to the right
        int leftPartLength = array.length - rightPartLength;//goes to the left
        for (int i = 0; i < rightPartLength; i++) {
            exchangedArray[i] = array[index + 1 + i];
        }
        for (int j = 0; j < leftPartLength; j++) {
            exchangedArray[rightPartLength + j] = array[j];
        }
        return exchangedArray;
    }

    static boolean validateCount(int index, int length) {
        return index >= 0 && index <= length;
    }

    static boolean validateIndex(int index, int length) {
        return index >= 0 && index < length;
    }

}

