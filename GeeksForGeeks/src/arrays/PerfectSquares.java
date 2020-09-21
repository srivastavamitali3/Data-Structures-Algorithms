package arrays;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(13));
    }

    public int numSquares(int n) {
        List<Integer> llist = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            if (Math.sqrt(i) == (int)Math.sqrt(i))
                llist.add(i);

        int count = 0;
        for (Integer j : llist) {
            n -= j;
            count++;
            if(n == 0)
                break;
        }
        return count;
    }
}
