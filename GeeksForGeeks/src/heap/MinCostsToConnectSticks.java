package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostsToConnectSticks {
    public static void main(String[] args) {
        System.out.println(new MinCostsToConnectSticks().connectSticks(new int[]{2, 4, 3}));
    }

    public int connectSticks(int[] sticks) {
        if (sticks.length == 1)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : sticks)
            pq.add(i);
        int result = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            result += first + second;
            pq.add(first + second);
        }

        return result;
    }

    public int connectSticks1(int[] sticks) {
        if (sticks.length == 0) return 0;

        int[] results = new int[sticks.length - 1];

        Arrays.sort(sticks);
        Arrays.fill(results, Integer.MAX_VALUE);

        int ans = 0;
        int stickIndex = 0;
        int resultIndex = 0;
        int resultPointer = 0;
        while (resultIndex < results.length) {
            int sum = 0;
            for (int i = 0; i < 2; ++i) {
                if (stickIndex < sticks.length && sticks[stickIndex] < results[resultPointer]) {
                    sum += sticks[stickIndex++];
                } else if (resultPointer < results.length) {
                    sum += results[resultPointer++];
                }
            }

            results[resultIndex++] = sum;
            ans += sum;
        }


        return ans;
    }
}
