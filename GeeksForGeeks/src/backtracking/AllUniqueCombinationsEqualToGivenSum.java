package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class AllUniqueCombinationsEqualToGivenSum {
    public static void main(String[] args) {
        List<List<Integer>> res = new AllUniqueCombinationsEqualToGivenSum()
                .combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(res);
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int[] candidates, int target, int offset, ArrayList<Integer> combinations, List<List<Integer>> result) {
        if (target < 0)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(combinations));
            return;
        }

        for (int i = offset; i < candidates.length; i++) {
            // Do not continue iteration of the remaining elements if the target - current element is less than 0.
            // This works because the array is sorted and it is guaranteed to not find an element which will satisfy
            // this condition for the remaining elements
            if (target - candidates[i] < 0)
                return;

            combinations.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, combinations, result);
            combinations.remove(combinations.size() - 1);

            //this is done because if you have already chosen a number once and generated its combinations,
            // then you don"t need to choose it again as only unique combinations are needed and since the
            // array is sorted, this will work

            while ((i + 1 < candidates.length && candidates[i] == candidates[i + 1]))
                i++;
        }
    }
}
