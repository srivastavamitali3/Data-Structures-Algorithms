package amazonQuestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(mostCommonWord(paragraph,banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();

        String[] str = paragraph.toLowerCase().replace(",","").replace(".","").
                replace("!","").split("\\s+");
        for (String s : str)
            map.put(s, map.getOrDefault(s, 0) + 1);
        for (String ban : banned)
            if (map.containsKey(ban))
                map.remove(ban);
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<String, Integer> entry : map.entrySet())
            maxHeap.add(entry);

        Map.Entry<String, Integer> res = maxHeap.poll();

        return res.getKey();
    }
}
