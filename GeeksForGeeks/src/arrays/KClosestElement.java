package arrays;

import java.util.Scanner;

public class KClosestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KClosestElement obj = new KClosestElement();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            int k = sc.nextInt();
            int X = sc.nextInt();
            obj.closestElement(n, arr, k, X);
        }
    }

    private void closestElement(int n, int[] arr, int k, int X) {
        int position = findCrossOverPoints(arr, 0, n - 1, X);
        int leftCount = 0;
        int rightCount = 0;
        int limit = k / 2;
        int originalLimit = limit;
        int count = 0;
        int temp = k;
        while (leftCount != originalLimit && limit > -1) {
            if (position == 0)
                break;
            if (position - limit < 0) {
                limit--;
                System.out.print(arr[position - limit] + " ");
                count++;
                break;
            } else {
                System.out.print(arr[position - limit] + " ");
                limit--;
            }
            leftCount++;
            count++;
        }
        limit = 1;
        while (rightCount != originalLimit && limit < n && count < k) {
            if (position + limit >= n) {
                while (count < k) {
                    System.out.print(arr[position - temp] + " ");
                    temp--;
                    count++;
                }
                break;
            }
            System.out.print(arr[position + limit] + " ");
            rightCount++;
            limit++;
            count++;
        }

        while (count < k) {
            System.out.print(arr[position + limit]);
            limit++;
            count++;
        }
    }


    private int findCrossOverPoints(int[] arr, int low, int high, int x) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return findCrossOverPoints(arr, low, mid - 1, x);
            return findCrossOverPoints(arr, mid + 1, high, x);
        }
        return -1;
    }
}
