package amazonQuestions;

/**
 * Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less than 231 - 1.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * <p>
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * <p>
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * <p>
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class IntegerToEnglishWords {
    public static void main(String[] args) {
        System.out.println(new IntegerToEnglishWords().numberToWords(12345879));
    }

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int i = 0;
        String numberName = "";
        while (num > 0) {
            if (num % 1000 != 0)
                numberName = convertToWords(num % 1000) + THOUSANDS[i] + " " + numberName;
            num = num / 1000;
            i++;
        }
        return numberName.trim();
    }

    private String convertToWords(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + convertToWords(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + convertToWords(num % 100);
    }


}
