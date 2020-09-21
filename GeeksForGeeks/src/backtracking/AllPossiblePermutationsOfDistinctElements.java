package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Sample Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class AllPossiblePermutationsOfDistinctElements {
    public static void main(String[] args) {
        System.out.println(new AllPossiblePermutationsOfDistinctElements().permute(new int[]{1, 2, 3, 4}));
        System.out.println(new AllPossiblePermutationsOfDistinctElements().permute(new int[]{1, 1, 2}));
    }

    private List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        dfs(nums, new ArrayList<Integer>(), result, new boolean[nums.length]);
        return result;
    }

    private void dfs(int[] nums, List<Integer> permutations, List<List<Integer>> result, boolean[] visited) {
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
        }
    }
}
