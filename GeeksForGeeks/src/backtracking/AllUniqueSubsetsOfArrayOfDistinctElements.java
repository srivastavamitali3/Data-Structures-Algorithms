package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Sample Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class AllUniqueSubsetsOfArrayOfDistinctElements {
    public static void main(String[] args) {
        System.out.println(new AllUniqueSubsetsOfArrayOfDistinctElements().subsets(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0 || nums == null) {
            result.add(new ArrayList<>());
            return result;
        }
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int offset, ArrayList<Integer> subsets, List<List<Integer>> result) {
        result.add(new ArrayList<>(subsets));

        for (int i = offset; i < nums.length; i++) {
            subsets.add(nums[i]);
            dfs(nums, i + 1, subsets, result);
            subsets.remove(subsets.size() - 1);
        }
    }
}
