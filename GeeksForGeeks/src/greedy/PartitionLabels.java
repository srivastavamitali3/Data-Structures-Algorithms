package greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {

    }

    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0)
            return new ArrayList<>();

        List<Integer> labels = new ArrayList<>();
        int[] map = new int[26];

        for (int i = 0; i < S.length(); i++)
            map[S.charAt(i) - 'a'] = i;

        int start = 0, last = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                labels.add(last - start + 1);
                start = last+1;
            }
        }
        return labels;
    }
}
