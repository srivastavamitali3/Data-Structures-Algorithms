package arrays;

/*
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    public static int minSubArrayLen(int s, int[] nums) {

        /*int i = 0;
        int j = 1;
        int min_length = Integer.MAX_VALUE;
        int sum = nums[i] + nums[j];
        while (j < nums.length) {
            if (sum == s && min_length > (j - i)) {
                min_length = (j - i) + 1;
                if (j <= nums.length)
                    j++;
            } else {
                if (sum < s) {
                    j++;
                    sum += nums[j];
                } else {
                    i++;
                    sum = 0;
                    sum += nums[i];
                    j = i + 1;
                    sum += nums[j];
                }
            }
        }

        return min_length;*/
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;


    }

    public int[] productExceptSelf(int[] nums) {
        int prod = 1; int k = -1;
        for(int i : nums)
            prod *= i;

        for(int i : nums)
            if(prod != 0)
                nums[++k] = prod / i;

        return nums;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
}
