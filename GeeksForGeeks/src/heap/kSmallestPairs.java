package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Basic idea: Use min_heap to keep track on next minimum pair sum, and we only need to maintain K possible candidates in the data structure.

Some observations: For every numbers in nums1, its best partner(yields min sum) always starts from
nums2[0] since arrays are all sorted; And for a specific number in nums1, its next candidate sould be
 [this specific number] + nums2[current_associated_index + 1], unless out of boundary;)
 */
public class kSmallestPairs {
    public static void main(String[] args) {
        kSmallestPairs obj = new kSmallestPairs();
        int[] nums1 = new int[]{1, 7, 11};
        int[] nums2 = new int[]{2, 4, 6};
        int k = 3;
        System.out.println(obj.kSmallestPairs1(nums1, nums2, k));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (p, q) -> q[0] + q[1] - p[0] - p[1]
        );
        int n = nums1.length;
        int m = nums2.length;
        if (n == 0 || m == 0) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heap.add(new int[]{nums1[i], nums2[j]});
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }

        while (!heap.isEmpty()) {
            int[] top = heap.poll();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(top[0]);
            tmp.add(top[1]);
            result.add(tmp);
        }

        return result;
    }

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        int size = nums1.length;
        if (nums1.length == 0 || nums2.length == 0)
            return new ArrayList<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for (int i = 0; i < size; i++) {
            pq.add(new Tuple(i, 0, nums1[i] + nums2[0]));
        }
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        while (i != k && pq.size() != 0) {
            Tuple temp = pq.poll();
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(nums1[temp.x]);
            ans.add(nums2[temp.y]);
            list.add(ans);
            i++;
            if (temp.y + 1 < nums2.length)
                pq.add(new Tuple(temp.x, temp.y + 1, nums1[temp.x] + nums2[temp.y + 1]));
        }
        return list;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;

    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}
