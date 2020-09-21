package arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int a[] = new int[]{2, 2, 2, 2, 5, 5, 2, 3, 3};
        int size = a.length;
        printMajority(a, size);
    }

    private static int printMajority(int[] a, int size) {
        int n = size / 2;
        int majority_element = 0;
        boolean flag = false;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int count = 1;
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                int value = map.get(a[i]) + 1;
                if (value > n) {
                    majority_element = a[i];
                    flag = true;
                    break;
                }
                map.put(a[i], value);
            } else
                map.put(a[i], count);
        }

        return majority_element;
    }
}
