import java.util.*;
import java.util.stream.Collectors;

class GFG {

    public static List<String> funWithAnagrams(List<String> text) {
        // Write your code here
        List<String> res = new ArrayList<>();
        HashSet<String> found = new HashSet<String>();
        for (int i = 0; i < text.size(); i++) {
            String word = text.get(i);
            word = sort(word);
            if (!found.contains(word)) {

                res.add(text.get(i));
                found.add(word);
            }
        }

        Collections.sort(res);
        return res;
    }

    // Function to remove the anagram String
    static void removeAnagrams(String arr[], int N) {
        // vector to store the final result
        Vector<String> ans = new Vector<String>();

        // data structure to keep a mark
        // of the previously occured String
        HashSet<String> found = new HashSet<String>();

        for (int i = 0; i < N; i++) {

            String word = arr[i];

            // Sort the characters
            // of the current String
            word = sort(word);

            // Check if current String is not
            // present inside the hashmap
            // Then push it in the resultant vector
            // and insert it in the hashmap
            if (!found.contains(word)) {

                ans.add(arr[i]);
                found.add(word);
            }
        }

        // Sort the resultant vector of Strings
        Collections.sort(ans);

        // Print the required array
        for (int i = 0; i < ans.size(); ++i) {
            System.out.print(ans.get(i) + " ");
        }
    }

    static String sort(String inputString) {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }

    // Driver code
    public static void main(String[] args) {
        String arr[]
                = {"geeks", "keegs",
                "code", "doce"};
        int N = 4;

        removeAnagrams(arr, N);
    }

    public static int countPairs(List<Integer> numbers, int k) {
        // Write your code here
        /*int count = 0;
        for (int i = 0; i < numbers.size(); i++)
        {
            for (int j = i + 1; j < numbers.size(); j++)
                if (numbers.get(i) - numbers.get(j) == k ||
                        numbers.get(j) - numbers.get(i) == k)
                    count++;
        }
        return count;*/
        class Pair {
            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        /*int count = 0;
        Collections.sort(numbers); // Sort array elements
        Set<Pair> set = new HashSet<>();
        int l = 0;
        int r = 0;

        while (r < numbers.size()) {
            if (numbers.get(r) - numbers.get(l) == k) {
                set.add(new Pair(numbers.get(r),numbers.get(l)));
                l++;
                r++;
            } else if (numbers.get(r) - numbers.get(l) > k)
                l++;
            else // arr[r] - arr[l] < sum
                r++;
        }
        return set.size();*/
        int count = 0;
        List<Integer> newList = numbers.stream().distinct().collect(Collectors.toList());
        Collections.sort(newList); // Sort array element

        int l = 0;
        int r = 0;
        while(r < newList.size())
        {
            if(newList.get(r) - newList.get(l) == k)
            {
                count++;
                l++;
                r++;
            }
            else if(newList.get(r) - newList.get(l) > k)
                l++;
            else // arr[r] - arr[l] < sum
                r++;
        }
        return count;

    }
} 