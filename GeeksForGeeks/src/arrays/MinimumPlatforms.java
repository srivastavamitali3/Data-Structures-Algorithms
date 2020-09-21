package arrays;

import java.util.Arrays;
import java.util.Scanner;

/*Test Case
* 1
6
0900  0940 0950  1100 1500 1800
0910 1200 1120 1130 1900 2000
*
* */
public class MinimumPlatforms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinimumPlatforms obj = new MinimumPlatforms();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arrival = new int[n];
            for (int i = 0; i < n; i++)
                arrival[i] = sc.nextInt();
            int[] departure = new int[n];
            for (int i = 0; i < n; i++)
                departure[i] = sc.nextInt();
            System.out.println(obj.minimumPlatforms(n, arrival, departure));
        }
    }

    private int minimumPlatforms(int n, int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platform_req = 1, result = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platform_req++;
                i++;
                if (platform_req > result)
                    result = platform_req;
            } else {
                platform_req--;
                j++;
            }
        }
        return result;
    }
}
