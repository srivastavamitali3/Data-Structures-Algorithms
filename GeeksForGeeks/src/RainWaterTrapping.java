import java.util.Scanner;

/*Test Case
2
4
7 4 0 9
3
6 9 9
* */
public class RainWaterTrapping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            System.out.println(findTrappedWater(arr, n));
        }
    }

    private static int findTrappedWater(int[] arr, int n) {
        int water = 0;
        int low = 0, high = n - 1;
        int left_max = 0, right_max = 0;
        while (low <= high) {
            if (arr[low] < arr[high]) {
                if (arr[low] > left_max)
                    left_max = arr[low];
                else {
                    water += left_max - arr[low];
                    low++;
                }
            } else {
                if (arr[high] > right_max)
                    right_max = arr[high];
                else {
                    water += right_max - arr[high];
                    high--;
                }
            }
        }
        return water;
    }
}
