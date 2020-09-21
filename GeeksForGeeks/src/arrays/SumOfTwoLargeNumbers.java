package arrays;

import java.math.BigInteger;
import java.util.Scanner;

public class SumOfTwoLargeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SumOfTwoLargeNumbers obj = new SumOfTwoLargeNumbers();
        int t = sc.nextInt();
        while (t-- > 0) {
            BigInteger X = sc.nextBigInteger();
            BigInteger Y = sc.nextBigInteger();
            System.out.println(obj.sumOfTwoLargeNumbers(X, Y));
        }
    }

    private BigInteger sumOfTwoLargeNumbers(BigInteger x, BigInteger y) {
        int digitsOfX = countDigits(x);
        BigInteger sum = x.add(y);
        int digitsOfSum = countDigits(sum);
        return digitsOfSum == digitsOfX ? sum : x;
    }

    private int countDigits(BigInteger x) {
        int count = 0;
        while (x != BigInteger.ZERO) {
            BigInteger temp = x.mod(BigInteger.valueOf(10));
            count++;
            x = x.divide(BigInteger.valueOf(10));
        }
        return count;
    }
}
