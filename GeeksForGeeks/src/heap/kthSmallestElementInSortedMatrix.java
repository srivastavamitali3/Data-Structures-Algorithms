package heap;

/*Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.*/

import java.util.PriorityQueue;

public class kthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};
        int k = 8;
        System.out.println(smallestElement(matrix, k));
    }

    private static int smallestElement(int[][] matrix, int k) {
        int smallestElement = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                pq.add(matrix[i][j]);
        }
        int count = 0;
        while (count != k){
            int value = pq.poll();
            count ++;
            if(count == k)
                smallestElement = value;
        }
        return smallestElement;
    }
}
