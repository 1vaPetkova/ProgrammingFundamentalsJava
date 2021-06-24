package T03arrays.exercise;

import java.util.Scanner;

public class P09kaminoFactory_NFv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sizeField = Integer.parseInt(sc.nextLine());

        String input = sc.nextLine();
        String forAllZeros = input;



        int numberDNAtest = 0;
        int localNumber = 0;
        int bestSum = 0;
        int bestLength = 0;
        int bestNumber = 0;
        int bestIndex = 0;
        String bestSequence = "";
        String bestInput = "";
        boolean zeros = false;


        String localnput = "";
        while (!input.equals("Clone them!")) {

            String noChars = input.replaceAll("!+", "");
            String[] noZeros = noChars.split("0");
            numberDNAtest++;
            int localLength = 0;
            String localSequence = "";
            int sum = 0;


            for (int j = 0; j < noZeros.length; j++) {
                if (noZeros[j].length() > localLength) {
                    localLength = noZeros[j].length();
                    localNumber = numberDNAtest;
                    localSequence = noZeros[j];
                    localnput = noChars;

                }
                sum += noZeros[j].length();
                if (sum > 0) {
                    zeros = true;
                }
            }
            int localIndex = noChars.indexOf(localSequence);

            if (localLength > bestLength) {
                bestLength = localLength;
                bestNumber = numberDNAtest;
                bestInput = localnput;
                bestSum = sum;
                bestIndex = localIndex;


            } else if (localLength == bestLength) {
                if (localIndex < bestIndex) {
                    bestLength = localLength;
                    bestNumber = numberDNAtest;
                    bestInput = localnput;
                    bestSum = sum;
                    bestIndex = localIndex;
                } else if (localIndex == bestIndex) {
                    if (bestSum < sum) {
                        bestLength = localLength;
                        bestNumber = numberDNAtest;
                        bestInput = localnput;
                        bestSum = sum;
                        bestIndex = localIndex;
                    }
                } else {
                    continue;
                }
            }

            localLength = 0;
            localNumber = 0;
            localSequence = "";
            localnput = "";
            sum = 0;


            input = sc.nextLine();


        }
        if (zeros == false) {
            String output1 = forAllZeros.replaceAll("!+","");  //Проверка когато входа е 0!0!0!0!0
            String [] bestAllZero = output1.split("");

            System.out.println("Best DNA sample 1" + " with sum: " + 0 + ".");
            for (int i = 0; i < bestAllZero.length; i++) {
                System.out.print(bestAllZero[i] + " ");
            }

        } else {
            String[] output = bestInput.split("");

            System.out.println("Best DNA sample " + bestNumber + " with sum: " + bestSum + ".");
            for (int i = 0; i < output.length; i++) {
                System.out.print(output[i] + " ");
            }
        }

    }
}