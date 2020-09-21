package arrays;

import javafx.beans.binding.ListBinding;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        pascalTriangle(numRows);
    }

    private static void pascalTriangle(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            int k = 1;
            List<Integer> ll = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                ll.add(k);
                k = k * (i - j) / j;
            }
            list.add(ll);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
