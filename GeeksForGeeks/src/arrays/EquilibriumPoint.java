package arrays;

public class EquilibriumPoint {
    public static void main(String[] args) {
        long[] arr = new long[]{1, 3, 5, 2, 2};
        System.out.println(equilibriumPoint(arr, arr.length));
    }

    private static int equilibriumPoint(long[] arr, int n) {
        long leftSum = 0, sum = 0;
        for (long i : arr)
            sum += i;
        for (int j = 0; j < n; j++) {
            sum -= arr[j];
            if (leftSum == sum)
                return j + 1;
            leftSum += arr[j];
        }
        return -1;
    }
}
