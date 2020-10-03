package amazonOnlineAssessment;

import java.util.*;

/**
 * Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.
 *
 * The comparison of strings is case-insensitive.
 * Multiple occurances of a keyword in a review should be considred as a single mention.
 * If keywords are mentioned an equal number of times in reviews, sort alphabetically.
 *
 * Example 1:
 *
 * Input:
 * k = 2
 * keywords = ["anacell", "cetracular", "betacellular"]
 * reviews = [
 *   "Anacell provides the best services in the city",
 *   "betacellular has awesome services",
 *   "Best services provided by anacell, everyone should use anacell",
 * ]
 *
 * Output:
 * ["anacell", "betacellular"]
 *
 * Explanation:
 * "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
 * Example 2:
 *
 * Input:
 * k = 2
 * keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
 * reviews = [
 *   "I love anacell Best services; Best services provided by anacell",
 *   "betacellular has great services",
 *   "deltacellular provides much better services than betacellular",
 *   "cetracular is worse than anacell",
 *   "Betacellular is better than deltacellular.",
 * ]
 *
 * Output:
 * ["betacellular", "anacell"]
 *
 * Explanation:
 * "betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.
 */
public class TopKFrequentlyMentionedWords {
    public static void main(String[] args) {

    }

    /**
     * it will be nlogk + klogk. nlogk because u insert n keywords to priority q of
     * size k (each insert log k). But then you got to remove all k elements from the
     * queue(u need to print them in order...) and each remove action is logk, hence klogk.
     * In total nlogk+klogk
     * @param k
     * @param keywords
     * @param reviews
     * @return
     */
    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        List<String> res = new ArrayList<>();
      //  Set<String> set = new HashSet<>(Arrays.asList(keywords));
        Set<String> set = new HashSet<>();
        for(String key : keywords) {
            set.add(key.toLowerCase());
        }
        Map<String, Integer> map = new HashMap<>();
        for (String r : reviews) {
            String[] strs = r.split("\\W");
            Set<String> added = new HashSet<>();
            for (String s : strs) {
                s = s.toLowerCase();
                if (set.contains(s) && !added.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    added.add(s);
                }
            }
        }
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>
                ((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) :
                        b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while (!maxHeap.isEmpty() && k-- > 0) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }
}
