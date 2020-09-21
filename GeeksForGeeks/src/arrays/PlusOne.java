package arrays;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 9};
        int[] x = plusOne(digits);
        for (int i : x)
            System.out.println(i);
    }

    private static int[] plusOne(int[] digits) {
        int count = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                count++;
                if (count == digits.length) {
                    int arr[] = new int[digits.length + 1];
                    arr[0] = 1;
                    return arr;
                }
            } else {
                digits[i] += 1;
                break;
            }
        }
        return digits;
    }
}
