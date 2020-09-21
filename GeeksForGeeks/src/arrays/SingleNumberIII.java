package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SingleNumberIII {
    public static void main(String[] args) {
        int[] arr = singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        for (int i : arr)
            System.out.println(i);
    }

    public static int[] singleNumber(int[] nums) {
        /*Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        int j = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) {
                j++;
            }
        }

        int[] res = new int[j];
        int k = 0;
        for (Integer i : map.keySet())
            if (map.get(i) == 1)
                res[k++] = i;

        return res;*/

        int bitmask = 0;
        for (int n : nums)
            bitmask ^= n;
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int n : nums) {
            if ((diff & n) != 0)
                x ^= n;
        }
        return new int[]{x, bitmask ^ x};
    }
}
