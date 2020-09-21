package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("23"));
    }

    private List<String> letterCombinations(String digits) {
        char[][] numPad = {{}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return result;

        digits2Number(numPad, 0, new StringBuffer(), result, digits);

        return result;
    }

    private void digits2Number(char[][] numPad, int currentDigit, StringBuffer currentBuffer, List<String> result, String digits) {
        if (currentDigit == digits.length()) {
            result.add(currentBuffer.toString());
            return;
        }
        int currentNum = digits.charAt(currentDigit) - '0' - 1;
        for (int i = 0; i < numPad[currentNum].length; i++) {
            currentBuffer.append(numPad[currentNum][i]);
            digits2Number(numPad, currentDigit + 1, currentBuffer, result, digits);
            currentBuffer.deleteCharAt(currentBuffer.length() - 1);
        }

    }
}
