package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = new int[]/*{16, 17, 4, 3, 5, 2}*/{4, 1, 4};
        ArrayList<Integer> al = leaders(arr, arr.length);
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");
    }

    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                leaders.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
