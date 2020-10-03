package amazonOnlineAssessment;

/**
 * Amazon Fresh is running a promotion in which customers receive prizes for purchasing
 * a secret combination of fruits. The combination will change each day, and the team running
 * the promotion wants to use a code list to make it easy to change the combination.
 * The code list contains groups of fruits. Both the order of the groups within the code list and
 * the order of the fruits within the groups matter. However, between the groups of fruits, any number,
 * and type of fruit is allowable. The term "anything" is used to allow for any type of fruit to appear in
 * that location within the group.
 * Consider the following secret code list: [[apple, apple], [banana, anything, banana]]
 * Based on the above secret code list, a customer who made either of the following purchases
 * would win the prize:
 * orange, apple, apple, banana, orange, banana
 * apple, apple, orange, orange, banana, apple, banana, banana
 * Write an algorithm to output 1 if the customer is a winner else output 0.
 *
 * Input
 * The input to the function/method consists of two arguments:
 * codeList, a list of lists of strings representing the order and grouping of specific fruits
 * that must be purchased in order to win the prize for the day.
 * shoppingCart, a list of strings representing the order in which a customer purchases fruit.
 * Output
 * Return an integer 1 if the customer is a winner else return 0.
 * Note
 * 'anything' in the codeList represents that any fruit can be ordered in place of '
 * anything' in the group. 'anything' has to be something, it cannot be "nothing."
 * 'anything' must represent one and only one fruit.
 * If secret code list is empty then it is assumed that the customer is a winner.
 */

import java.util.List;

/**
 * @author Mitali Srivastava
 */
public class amazonFreshPromotion {
    public static void main(String[] args) {
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
        String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};
        String[][] codeList9= { { "anything", "anything", "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart9 = {"orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"};
    }

    public static int winPrize(List<List<String>> codeList, List<String> shoppingCart) {
        if (codeList == null || codeList.size() == 0) {
            return 1;
        }
        if (shoppingCart == null || shoppingCart.size() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (i < codeList.size() && j + codeList.get(i).size() <= shoppingCart.size()) {
            boolean match = true;
            for (int k = 0; k < codeList.get(i).size(); k++) {
                if (!codeList.get(i).get(k).equals("anything")
                        && !shoppingCart.get(j + k).equals(codeList.get(i).get(k))) {
                    match = false;
                    break;
                }
            }
            if (match) {
                j += codeList.get(i).size();
                i++;
            } else {
                j++;
            }
        }

        return (i == codeList.size()) ? 1 : 0;
    }
}
