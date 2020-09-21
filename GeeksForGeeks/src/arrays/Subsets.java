package arrays;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets obj = new Subsets();
        List<List<Integer>> result = obj.subsets(new int[]{1, 2, 3});

        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));


    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> subsets = new ArrayList<>();
            int m = 1;
            for (int j = 0; j < nums.length; j++) {
                if ((i & m) > 0 && !subsets.contains(nums[j]))
                    subsets.add(nums[j]);
                m = m << 1;
            }
            result.add(subsets);
        }

        return result;
    }
}
