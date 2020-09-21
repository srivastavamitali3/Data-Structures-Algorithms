package amazonQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = new MergeIntervals().merge(new int[][]{{1,4},{4,5}});
        int i = 0;
        for(int[] curr : arr)
            System.out.println(curr[i++]);
    }
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return new int[][]{};

        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        List<int[]> result = new ArrayList<>();

        int[] prev = intervals[0];
        for(int[] curr : intervals){
            if(prev[1] >= curr[0])
                prev = new int[]{prev[0],Math.max(prev[1],curr[1])};
            else{
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        return result.toArray(new int[result.size()][]);
    }
}
