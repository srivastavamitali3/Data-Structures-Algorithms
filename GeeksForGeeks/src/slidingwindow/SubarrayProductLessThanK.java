package slidingwindow;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        SubarrayProductLessThanK obj = new SubarrayProductLessThanK();
        System.out.println(obj.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int left = 0;
        int prod = 1;
        for (int right = 0; right < n; right++) {
            prod *= nums[right];
            while (left <= right && prod >= k)
                prod /= nums[left++];

            count += right - left + 1;
        }
        return count;
    }
}
