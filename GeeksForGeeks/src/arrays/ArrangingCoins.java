package arrays;

public class ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoins obj = new ArrangingCoins();
        int n = 8;
        System.out.println(obj.arrangeCoins(n));
        System.out.println(obj.arrangeCoinsBinSearch(n));
    }

    public int arrangeCoins(int n) {
        int res = 0;
        while (n > 0) {
            if (n > res) {
                res++;
                n -= res;
            } else {
                break;
            }
        }
        return res;
    }

    public int arrangeCoinsBinSearch(int n) {
        int left = 0;
        int right = n;
        long k, current;
        while (left <= right) {
            k = (int) (left + (right - left) / 2);
            current = k * (k + 1) / 2;

            if (current == n)
                return (int) k;
            if (n < current)
                right = (int) (k - 1);
            else
                left = (int) (k + 1);
        }
        return right;
    }
}
