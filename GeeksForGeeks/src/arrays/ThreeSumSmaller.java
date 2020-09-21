package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1};
        System.out.println(threeSumSmaller(arr, 2));
        int[] arr1 = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr1));
    }

    public static int threeSumSmaller(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    result = k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int target = nums[i] + nums[j] + nums[k];
                if (target == 0) {
                    List<Integer> list = new ArrayList<Integer>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    if (!result.contains(list))
                        result.add(list);
                    j++;
                } else if (target > 0)
                    k--;
                else
                    j++;
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int N = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < N - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int low = i + 1;
            int high = N - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[low] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return ans;
    }

}
