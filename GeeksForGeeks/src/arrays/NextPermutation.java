package arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] x = nextPermutation(new int[]{1, 2, 3});
        for (int i : x)
            System.out.print(i);
    }

    private static int[] nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 1; i > 0; i--)
            if (nums[i] > nums[i - 1])
                break;
        if (i == 0) {
            nums[i] = 0;
        } else {
            int x = nums[i - 1], min = i;
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] > x && nums[j] < nums[min])
                    min = j;
            swap(nums, i - 1, min);

            Arrays.sort(nums, i, nums.length);
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int min) {
        int temp = nums[i];
        nums[i] = nums[min];
        nums[min] = temp;
    }

    public void nextPermutation(int[] nums, boolean flag) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
