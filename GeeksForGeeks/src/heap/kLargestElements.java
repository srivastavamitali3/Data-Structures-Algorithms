package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
/*Test Case
        2
        5 2
        12 5 787 1 23
        7 3
        1 23 12 9 30 2 50*/
public class kLargestElements {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] = new int[n];
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();

            kthLargest(arr, n, k);

        }
    }

    private static void kthLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr)
            pq.add(i);
        int count = 0;
        while (count != k) {
            int value = pq.poll();
            System.out.print(value+" ");
            count++;
        }
        System.out.println();
    }
}
