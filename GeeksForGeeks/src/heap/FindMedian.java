package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
/*Test Case
        4
        5
        15
        1
        3
 1)Each element is added to the min heap first
 2)Then the min element is popped out from min heap and added to max heap
 3)This assures that all the elements in the min heap are greater than max heap
 4)2 heaps need to be balanced
 */
public class FindMedian {
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        FindMedian Ans = new FindMedian();
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            Ans.insertHeap(x);
            System.out.println((int) Math.floor(Ans.getMedian()));
        }
    }

    private double getMedian() {
        if(min.size() > max.size())
            return min.peek();
        else
            return (min.peek()+max.peek())/2.0;
    }

    private void insertHeap(int x) {
        min.add(x);
        max.add(min.poll());
        if(min.size() < max.size())
            min.add(max.poll());
    }
}
