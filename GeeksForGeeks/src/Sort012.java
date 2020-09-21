import java.util.Scanner;

/*1
        5
        0 2 1 2 0*/
public class Sort012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            sort012(arr, n);
            // sort01(arr, n);
            System.out.println();
            for (int i : arr)
                System.out.print(i + " ");
        }
    }

    private static void sort012(int[] arr, int n) {
        int low = 0, mid = 0, temp = 0, high = n - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0: {
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }

    private static void sort01(int[] arr, int n) {
        int low = 0, mid = 0, temp = 0, high = n - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0: {
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    mid++;
                }
            }
        }
    }
}
