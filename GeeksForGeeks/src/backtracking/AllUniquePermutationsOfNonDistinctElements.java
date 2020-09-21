package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Sample Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class AllUniquePermutationsOfNonDistinctElements {
    public static void main(String[] args) {
        System.out.println(new AllUniquePermutationsOfNonDistinctElements().permute(new int[]{1, 1, 2}));
    }

    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0 || nums == null) {
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), result, new boolean[nums.length + 1]);

        return result;
    }

    private void dfs(int[] nums, ArrayList<Integer> permutations, List<List<Integer>> result, boolean[] visited) {
        if (permutations.size() == nums.length) {
            result.add(new ArrayList<>(permutations));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            permutations.add(nums[i]);
            dfs(nums, permutations, result, visited);
            permutations.remove(permutations.size() - 1);
            visited[i] = false;

            while ((i + 1 < nums.length) && nums[i] == nums[i + 1])
                i++;
        }

    }
}
