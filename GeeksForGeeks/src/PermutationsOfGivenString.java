import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PermutationsOfGivenString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            ArrayList<String> al = new ArrayList<String>();
            permute(s, 0, n - 1, al);
            Collections.sort(al);
            for (String str : al)
                System.out.print(str + " ");
            System.out.println();
        }
    }

    private static ArrayList<String> permute(String s, int low, int high, ArrayList<String> al) {
        if (low == high)
            al.add(s);
        else {
            for (int i = low; i <= high; i++) {
                s = swap(s, low, i);
                permute(s, low + 1, high, al);
                s = swap(s, low, i);
            }
        }
        return al;
    }

    private static String swap(String s, int i, int j) {
        char temp;
        char[] array = s.toCharArray();
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return String.valueOf(array);
    }
}
