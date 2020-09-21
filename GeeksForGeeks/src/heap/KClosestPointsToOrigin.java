package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        //[[1,3],[-2,2]], K = 1
        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
        int[][] arr = obj.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        for (int[] ints : arr) {
            for(int i : ints)
            System.out.println(i);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        /*int x1 = 0, y1 = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] result = new int[K + 1][K + 1];
        int lastDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            int distance = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            System.out.println("distance :"+distance);
            if (distance < lastDistance) {
                pq.add(distance);
                lastDistance = distance;
            } else {
                pq.add(distance);
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        return result;*/

        /*Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);*/

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }
}
