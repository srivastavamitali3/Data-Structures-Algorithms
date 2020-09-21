package arrays;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    private static int maxSubArraySum(int[] a) {
        int n = a.length, max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        int index = 0, startIndex = 0, endIndex = 0;
        for (int i = 0; i < n; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                startIndex = index;
                endIndex = i;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
                index = i + 1;
            }
        }

        for (int j = startIndex; j <= endIndex; j++)
            System.out.print(a[j] + ",");

        return max_so_far;
    }
}
