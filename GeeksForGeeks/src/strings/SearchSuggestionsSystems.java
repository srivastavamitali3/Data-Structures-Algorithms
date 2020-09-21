package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of strings products and a string searchWord.
 * We want to design a system that suggests at most three product names from products after each
 * character of searchWord is typed. Suggested products should have common prefix with the searchWord.
 * If there are more than three products with a common prefix return the three lexicographically minimums products.
 * <p>
 * Return list of lists of the suggested products after each character of searchWord is typed.
 * <p>
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * <p>
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 */
public class SearchSuggestionsSystems {
    public static void main(String[] args) {
        System.out.println(new SearchSuggestionsSystems()
                .suggestedProducts(new String[]{"bags","baggage","banner","box","cloths"},"bags"));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestedList = new ArrayList<>();
        Arrays.sort(products);

        int n = products.length;
        String word = "";

        for (char c : searchWord.toCharArray()) {
            word += c;
            int k = 3;
            List<String> prod = new ArrayList<>();
            int i = 0;
            while (k > 0 && i < n) {
                if(products[i].startsWith(word)){
                    prod.add(products[i]);
                    k--;
                }
                i++;
            }
            suggestedList.add(prod);
        }

        return suggestedList;
    }
}
