package heap;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        /*int[] nums = new int[]{1};
        int k = 1;
        int[] arr = topKFrequent(nums, k);
        for (int i : arr)
            System.out.println(i);

        List<String> llist = topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        llist.forEach(value -> System.out.println(value));*/

        int topNCompetitiors = 2;
        String[] array = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] words = {"I love anacell Best services provided by anacell in the town", "betacellular has great " +
                "services", "deltacellular provides much better services than betacellular", "cetracular is worse than " +
                "eurocell", "betacellular is better than deltacellular"};


       System.out.println(topKFrequent(Arrays.asList(words), topNCompetitiors, Arrays.asList(array)));
      //  System.out.println(getFrequent(topNCompetitiors,Arrays.asList(array),Arrays.asList(words)));
    }


    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if (nums.length == 1)
            return nums;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            maxHeap.add(entry);
        int count = 0;
        while (count < k) {
            Map.Entry<Integer, Integer> freqEle = maxHeap.poll();
            result[count] = freqEle.getKey();
            count++;
        }
        return result;
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        for (String str : words)
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);

        PriorityQueue<String> maxHeap = new PriorityQueue<>(
                (a, b) -> freqMap.get(a).equals(freqMap.get(b)) ?
                        b.compareTo(a) : (freqMap.get(a) - freqMap.get(b)));
        for (String entry : freqMap.keySet()) {
            maxHeap.offer(entry);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        while (!maxHeap.isEmpty())
            result.add(maxHeap.poll());

        Collections.reverse(result);
        return result;
    }

    /*public static List<String> topKFrequent(List<String> words, int topNCompetitiors, List<String> competitors) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String comp : competitors)
            set.add(comp);
        for (String word : words) {
            String[] str = word.split(" ");
            for (String s : str) {
                if (set.contains(s))
                    freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
            }
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>(
                (a, b) -> freqMap.get(a).equals(freqMap.get(b)) ?
                        b.compareTo(a) : (freqMap.get(a) - freqMap.get(b)));
        for (String entry : freqMap.keySet()) {
            maxHeap.offer(entry);
            if (maxHeap.size() > topNCompetitiors)
                maxHeap.poll();
        }

        while (!maxHeap.isEmpty())
            result.add(maxHeap.poll());

        Collections.reverse(result);
        return result;
    }*/

    public static List<String> topKFrequent(List<String> words, int topNCompetitiors, List<String> competitors) {
        if (topNCompetitiors >= competitors.size())
            return competitors;
        if (topNCompetitiors <= 0 || null == words || words.size() == 0)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String comp : competitors)
            set.add(comp);
        for (String word : words) {
            Set<String> added = new HashSet<>();
            String[] str = word.split(" ");
            for (String s : str) {
                if (set.contains(s) && !added.contains(s)) {
                    freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
                    added.add(s);
                }

            }
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> {
            if (freqMap.get(b) - freqMap.get(a) != 0)
                return freqMap.get(b) - freqMap.get(a);
            return a.compareTo(b);
        });
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(entry.getKey());
        }
        int k = 0;
        while (k < topNCompetitiors && !maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
            k++;
        }

        //    Collections.reverse(result);
        return result;
    }

    public static List<String> getFrequent(int k,List<String> competitors,List<String> reviews){
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(competitors);
        Map<String, Integer> map = new HashMap<>();
        for(String r : reviews) {
            String[] strs = r.split("\\W");
            Set<String> added = new HashSet<>();
            for(String s : strs) {
                s = s.toLowerCase();
                if(set.contains(s) && !added.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    added.add(s);
                }
            }
        }
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ?
                a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while(!maxHeap.isEmpty() && k-- > 0) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }

}
