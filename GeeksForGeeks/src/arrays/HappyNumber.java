package arrays;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }

    private static boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int digitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }
}
