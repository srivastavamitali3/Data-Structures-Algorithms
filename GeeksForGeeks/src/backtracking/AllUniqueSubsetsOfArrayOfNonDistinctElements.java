package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllUniqueSubsetsOfArrayOfNonDistinctElements {
    public static void main(String[] args) {
        System.out.println(new AllUniqueSubsetsOfArrayOfNonDistinctElements().subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(new AllUniqueSubsetsOfArrayOfNonDistinctElements().subsetsWithDup(new int[]{4, 1, 4, 4, 4}));
    }

    private List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int[] nums, int offset, ArrayList<Integer> subsets, List<List<Integer>> result) {
        result.add(new ArrayList<>(subsets));

        for (int i = offset; i < nums.length; i++) {
            subsets.add(nums[i]);
            dfs(nums, i + 1, subsets, result);
            subsets.remove(subsets.size() - 1);

            while (i + 1 < nums.length && nums[i] == nums[i + 1])
                i++;
        }
    }
}
