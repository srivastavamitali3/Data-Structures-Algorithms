package amazonQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class LargestItemAssociation {
    public static void main(String[] args) {
        LargestItemAssociation obj = new LargestItemAssociation();
        PairString[] strs = {
                obj.new PairString("item2", "item3"), // -> item1, item3, item2
                obj.new PairString("item0", "item1"), //
                obj.new PairString("item2", "item1") //
        };
        List<PairString> pairs = Arrays.asList(strs);
        List<String> result = obj.largestItemAssociation(pairs);
        System.out.println(result);
    }

    public List<String> largestItemAssociation(List<PairString> itemAssociation) {
        if (itemAssociation.isEmpty())
            return null;
        PriorityQueue<Set<String>> max_heap = new PriorityQueue<>(//
                (l1, l2) -> Integer.compare(l2.size(), l1.size()));//
        Collections.sort(itemAssociation, (a, b) -> a.first.compareTo(b.first));
        for (int pair = 0; pair < itemAssociation.size(); pair++) {
            Set<String> buildList = new TreeSet<>(Arrays.asList(itemAssociation.get(pair).first,
                    itemAssociation.get(pair).second));
            for (int inner = pair + 1; inner < itemAssociation.size(); inner++) {
                mergeTag(buildList, itemAssociation.get(inner));
            }
            max_heap.add(buildList);
        }

        return max_heap.poll().stream().collect(Collectors.toList());
    }

    private static void mergeTag(Set<String> buildList, PairString pairString) {
        if (buildList.contains(pairString.first) && buildList.contains(pairString.second))
            return;
        if (buildList.contains(pairString.first)) {
            buildList.add(pairString.second);
        } else if (buildList.contains(pairString.second)) {
            buildList.add(pairString.first);
        }

    }
    class PairString {
        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

}

