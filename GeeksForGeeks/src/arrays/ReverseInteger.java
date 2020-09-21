package arrays;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseInteger(-123));
    }

    private static int reverseInteger(int x) {
        long res = 0;
        if (x == 0)
            return 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            res = res * 10 + temp;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE)
            return 0;
        return (int) res;
    }
}
