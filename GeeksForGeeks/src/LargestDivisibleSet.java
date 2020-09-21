import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSet {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 4, 8};
        System.out.println(largestDivisibleSubset(arr));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> subset = new ArrayList<Integer>();
        if (nums != null && nums.length != 0) {
            Arrays.sort(nums);
            int N = nums.length, i, j;
            int[] DP = new int[N];
            int[] parent = new int[N];

            Arrays.fill(DP, 1);
            Arrays.fill(parent, -1);
            int max = 0, maxIndex = -1;

            for (i = 0; i < N; i++) {
                for (j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0 && DP[i] < DP[j] + 1) {
                        DP[i] = DP[j] + 1;
                        parent[i] = j;
                    }
                }

                if (DP[i] > max) {
                    maxIndex = i;
                    max = DP[i];
                }
            }

            while (maxIndex != -1) {
                subset.add(nums[maxIndex]);
                maxIndex = parent[maxIndex];
            }
        }
        Collections.sort(subset);
        return subset;
    }
}
