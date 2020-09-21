import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramsOfString {
    public static void main(String[] args) {
        String arr[] = {"cat", "dog", "tac", "god", "act"};
        /*List<List<String>> list = printAnagrams(arr);
        Iterator itr = list.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }*/
        Solution sol = new Solution();
        List<List<String>> list = sol.groupAnagrams(arr);
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        /*for (String s : map.keySet()) {
            List<String> values = map.get(s);
            if (values.size() > 1)
                list.add(values);
        }*/
    }

    private static List<List<String>> printAnagrams(String[] arr) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);

            if (map.containsKey(newWord)) {
                map.get(newWord).add(word);
            } else {
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord, words);
            }
        }

        for (String s : map.keySet()) {
            List<String> values = map.get(s);
            if (values.size() > 1)
                list.add(values);
            Collections.sort(values);
        }
        return list;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs).collect(Collectors.groupingBy(this::getKey))
                .values().stream().collect(Collectors.toList());
    }

    String getKey(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
