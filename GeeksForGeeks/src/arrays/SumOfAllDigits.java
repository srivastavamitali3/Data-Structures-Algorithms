package arrays;

import java.util.Scanner;

public class SumOfAllDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SumOfAllDigits obj = new SumOfAllDigits();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(obj.calcDigitSum(n));
        }
    }

    private int calcDigitSum(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp;
            n = n / 10;
            if (n == 0 && sum >= 10) {
                n = sum;
                sum = 0;
            }
        }
        return sum;
    }
}
