package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        //   System.out.println(removeElement(nums, val));
        int[] arr = new int[]{1, 3, 5, 6};
        int target = 7;
        //    System.out.println(searchInsert(arr, target));

        int[] arr1 = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(arr1);

    }

    private static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static int searchInsert(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length - 1, target);
    }

    static int binarySearch(int arr[], int low, int high, int key) {

        if (high < low)
            return low;

        /*low + (high - low)/2;*/
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        /*int target = 0;
        list.add(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(target - nums[i]);
            if (value == null)
                map.put(i, nums[i]);
            else {
                list.add(value);
                list.add(nums[i]);
                result.add(list);
            }
        }*/

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int target = nums[i] + nums[j] + nums[k];
                if (target == 0) {
                    List<Integer> list = new ArrayList<Integer>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
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
}
