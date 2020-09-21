package arrays;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SortedMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            SortedMatrix sm = new SortedMatrix();
            sm.sortMatrix(arr, n);
        }
    }

    private void sortMatrix(int[][] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                pq.add(arr[i][j]);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }
}
