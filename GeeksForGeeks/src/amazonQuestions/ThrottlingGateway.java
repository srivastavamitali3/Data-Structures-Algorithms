package amazonQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ThrottlingGateway {
    public static void main(String[] args) {
        int[] reqTime1 = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 11, 11, 11};
        //1 sec 3 transactions, 10 secs 20 transactions, 60 secs 60 transactions
        int N = 22;
        System.out.println("Total dropped request: " + droppedRequests(N, reqTime1));

        int[] reqTime2 = {1, 1, 1, 1, 2};
        N = 5;
        System.out.println("Total dropped request: " + droppedRequests(N, reqTime2));

        int[] reqTime3 = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7};
        N = 22;
        System.out.println("Total dropped request: " + droppedRequests(N, reqTime3));
    }

    private static int droppedRequests(int requestTimeCount, int[] requestTime) {
        int[][] limits = {{1, 3}, {10, 20}, {60, 60}};
        return throttlingGateway(requestTime, limits);
    }

    private static int throttlingGateway(int[] reqTime, int[][] limits) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i : reqTime) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            max = Math.max(max, i);
        }
        int[] nums = new int[max + 1];
        for (int key : map.keySet()) {
            nums[key] = map.get(key);
        }
        int[] preSum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        for (int[] limit : limits) {
            int time = Math.min(limit[0], preSum.length - 1);
            int maxCnt = limit[1];
            for (int i = 0; i < preSum.length - time; i++) {
                int cur = preSum[i + time] - preSum[i];
                res += cur > maxCnt ? cur - maxCnt : 0;
            }
        }
        return res;
    }


    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here
        int[][] events = new int[arrival.size()][2];
        for (int i = 0; i < arrival.size(); i++)
            events[i] = new int[]{arrival.get(i), arrival.get(i) + duration.get(i)};

        Arrays.sort(events, (a, b) -> (a[1] - b[1]));
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int[] first = events[0];
        for (int i = 1; i < events.length; i++) {
            int[] curr = events[i];
            if (curr[0] > first[1])
                minHeap.offer(curr);
            else
                first[1] = events[i][1];
        }
        return arrival.size() - minHeap.size();

    }
}
