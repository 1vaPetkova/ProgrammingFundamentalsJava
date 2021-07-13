package T03arrays.moreExercises;

import java.util.*;

public class P04longestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] seq = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] len = new int[seq.length];
        int[] prev = new int[seq.length];

        int bestIndex = calculateLongestIncreasingSubsequence(seq, len, prev);

        printLIS(seq, prev, bestIndex) ;

    }

    private static int calculateLongestIncreasingSubsequence(int[] seq, int[] len, int[] prev) {
        int maxIndex = 0;
        int maxLen = 0;

        for (int x = 0; x < seq.length; x++) {
            len[x] = 1;
            prev[x] = -1;
            for (int i = 0; i < x; i++) {
                if ((seq[i] < seq[x]) && (len[i] + 1 > len[x])) {
                    len[x] = len[i] + 1;
                    prev[x] = i;
                }
                if (len[x] > maxLen) {
                    maxLen = len[x];
                    maxIndex = x;
                }
            }
        }
        return maxIndex;
    }


    private static void printLIS(int[] seq, int[] prev, int index) {
        List<Integer> longestSeq = new ArrayList<>();
        while (index != -1) {
            longestSeq.add(seq[index]);
            index = prev[index];
        }
        Collections.reverse(longestSeq);
        for (Integer num : longestSeq) {
            System.out.print(num + " ");
        }
    }
}

