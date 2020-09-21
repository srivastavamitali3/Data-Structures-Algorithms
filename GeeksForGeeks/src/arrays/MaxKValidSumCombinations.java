package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//Complete heap and then solve this
public class MaxKValidSumCombinations {
    public static void main(String[] args) {
        int A[] = {4, 2, 5, 1} /*{1, 4, 2, 3}*/;
        int B[] = {8, 0, 5, 3}/*{2, 5, 1, 6}*/;
        int N = A.length;
        int K = 3;

        NMaxCombinations(A, B, N, K);
    }

    private static void NMaxCombinations(int[] a, int[] b, int n, int k) {
        Arrays.sort(b);
        int maxValueB = b[b.length - 1];
        Integer index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int j : a) {
            pq.add(j + maxValueB);
        }
        while (index != k) {
            System.out.print(pq.poll() + " ");
            index++;
        }
    }
}
