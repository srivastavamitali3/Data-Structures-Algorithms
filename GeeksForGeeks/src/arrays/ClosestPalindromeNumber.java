package arrays;

import java.util.Scanner;

/*Test Case
 * 1
 * 984
 * */
public class ClosestPalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClosestPalindromeNumber obj = new ClosestPalindromeNumber();
        int t = sc.nextInt();
        while (t-- > 0) {
            String n = sc.next();
            System.out.println(obj.closestPalindrome(n));
        }
    }

    public String closestPalindrome(String n) {
        long num = Long.parseLong(n);
        long newNum = num;
        long largePalin = 0;
        long smallPalin = 0;
        long unit = 1;
        long difference = Integer.MAX_VALUE;
        long temp = 0;
        if (isPalindrome(n))
            return n;
        for (int i = 0; i < n.length() / 2 - 1; i++)
            unit *= 10;

        do {
            largePalin = makePalindrome(newNum += unit);
            long newDifference = Math.abs(largePalin - num);
            if (difference > newDifference) {
                difference = newDifference;
                temp = largePalin;
            }
        } while (largePalin <= num);

        largePalin = temp;
        newNum = num;
        difference = Integer.MAX_VALUE;
        do {
            if (newNum < unit) break;
            smallPalin = makePalindrome(newNum -= unit);
            long newDiff = Math.abs(num - smallPalin);
            if (difference >= newDiff) {
                difference = newDiff;
                temp = smallPalin;
            }
        } while (smallPalin >= num);
        smallPalin = temp;

        return num - smallPalin <= largePalin - num ? String.valueOf(smallPalin) : String.valueOf(largePalin);
    }

    long makePalindrome(long num) {
        char[] arr = String.valueOf(num).toCharArray();
        int head = 0, tail = arr.length - 1;
        while (head < tail) {
            arr[tail--] = arr[head++];
        }
        return Long.parseLong(new String(arr));
    }

    boolean isPalindrome(String n) {
        StringBuffer str = new StringBuffer(n);
        str.reverse();
        if (n.equalsIgnoreCase(str.toString()))
            return true;
        return false;
    }
}
