package heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class kthLargestElementInUnsortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(largestElement(arr, k));
    }

    private static int largestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr)
            pq.add(i);
        int count = 0;
        int largestElement = Integer.MIN_VALUE;
        while (count != k) {
            int value = pq.poll();
            count++;
            if (count == k && value > largestElement)
                largestElement = value;
        }
        return largestElement;
    }
}
