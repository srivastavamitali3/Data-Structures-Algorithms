package arrays;

import java.util.*;

public class DuplicateElements {
    public static void main(String[] args) {
        DuplicateElements obj = new DuplicateElements();
        System.out.println(obj.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        /*int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            int index = nums[i] % n;
            nums[index] += n;
        }
        for (int i = 0; i < n; i++)
        {
            if ((nums[i]/n) > 1)
                res.add(i);
        }*/
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                res.add(Math.abs(num));
            }
            nums[Math.abs(num) - 1] *= -1;
        }
        return res;
    }
}
