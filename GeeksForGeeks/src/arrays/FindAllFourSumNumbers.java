package arrays;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class FindAllFourSumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FindAllFourSumNumbers obj = new FindAllFourSumNumbers();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            obj.findNumbers(arr, n, k);
            System.out.println();
        }
    }

    static class Pair {
        int first, second = 0;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Quadruplet {
        int a, b, c, d;

        public Quadruplet(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Quadruplet that = (Quadruplet) o;
            return a == that.a &&
                    b == that.b &&
                    c == that.c &&
                    d == that.d;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c, d);
        }
    }

    private void findNumbers(int[] arr, int n, int k) {
        String res1 = "";
        Map<Integer, Pair> map = new HashMap<>();
        Set<Quadruplet> set = new HashSet<>();
//        PriorityQueue<Quadruplet> pq = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                map.put(arr[i] + arr[j], new Pair(i, j));

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(k - sum)) {
                    Pair p = map.get(k - sum);
                    if (p.first != i && p.first != j && p.second != i && p.second != j) {
                        res1 = arr[i] + " " + arr[j] + " " + arr[p.first] + " " + arr[p.second];
                    }
                }
            }
        }

       /* for (String s : set)
            System.out.print(s + "$");*/
    }
}
