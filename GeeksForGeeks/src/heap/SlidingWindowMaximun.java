package heap;

import java.util.ArrayList;
import java.util.List;

//[1,3,-1,-3,5,3,6,7]
//3
public class SlidingWindowMaximun {
    public static void main(String[] args) {
        SlidingWindowMaximun obj = new SlidingWindowMaximun();
        int[] nums = new int[]{1, -1};//{1,3,-1,-3,5,3,6,7};
        int k = 1;
        int[] arr = obj.maxSlidingWindow(nums, k);
        for (int i : arr)
            System.out.println(i);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int maxNumber = Integer.MIN_VALUE;
        int i = 0, index = 0;
        boolean addNumber = false;
        while (count < nums.length && i < nums.length) {
            for (i = index; i < index + k; i++) {
                if (maxNumber < nums[i]) {
                    maxNumber = nums[i];
                    addNumber = true;
                }
            }
            index++;
            if (addNumber && maxNumber != Integer.MIN_VALUE)
                list.add(maxNumber);
            count++;
            maxNumber = Integer.MIN_VALUE;
        }

        int size = list.size();
        int[] res = new int[size];
        int j = 0;
        for (int m = 0; m < list.size(); m++)
            res[j++] = list.get(m);

        return nums.length == 1 ? nums : res;
    }

    public static int[] slidingWindowMax(final int[] in, final int w) {
        final int[] max_left = new int[in.length];
        final int[] max_right = new int[in.length];

        max_left[0] = in[0];
        max_right[in.length - 1] = in[in.length - 1];

        for (int i = 1; i < in.length; i++) {
            max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

            final int j = in.length - i - 1;
            max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
        }

        final int[] sliding_max = new int[in.length - w + 1];
        for (int i = 0, j = 0; i + w <= in.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
        }

        return sliding_max;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        int[] res = new int[m];
        res[0] = nums[0];
        for (int i = 1; i < k; i++) {
            res[0] = Math.max(res[0], nums[i]);
        }
        for (int i = 1; i < m; i++) {
            if (nums[i + k - 1] >= res[i - 1]) res[i] = nums[i + k - 1];
            else if (nums[i - 1] < res[i - 1]) res[i] = res[i - 1];
            else {
                res[i] = nums[i];
                for (int j = i + 1; j <= i + k - 1; j++) {
                    res[i] = Math.max(res[i], nums[j]);
                }
            }
        }
        return res;
    }
}
