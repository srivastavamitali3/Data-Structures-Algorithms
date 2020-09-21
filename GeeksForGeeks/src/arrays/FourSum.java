package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = fourSum1(nums, 0);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < 4; j++)
                System.out.print("[" + result.get(i).get(j) + "," + "]");
            System.out.println(",");
        }

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            int l = j + 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k] + nums[l];
                if (target == sum) {
                    List<Integer> list = new ArrayList<Integer>(4);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[l]);
                    list.add(nums[k]);
                    if (!result.contains(list))
                        result.add(list);
                    j++;
                } else if (sum > 0)
                    k--;
                else
                    j++;
            }
        }

        return result;
    }

    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {  //corner case
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {   //avoid duplicated
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {   //avoid duplicated
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int curr = nums[i] + nums[j] + nums[left] + nums[right];
                    if (curr == target) {
                        res.add(genList(nums, i, j, left, right));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (curr > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    private static List<Integer> genList(int[] nums, int i, int j, int k, int l) {
        List<Integer> t = new ArrayList<>();
        t.add(nums[i]);
        t.add(nums[j]);
        t.add(nums[k]);
        t.add(nums[l]);
        return t;
    }
}
