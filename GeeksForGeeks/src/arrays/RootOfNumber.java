package arrays;

public class RootOfNumber {
    public static void main(String[] args) {
        System.out.println(root(27,3));
    }

    static double root(double x, double n){
        double lo = 0.001, hi = x;
        while(hi - lo >= 0.001) {
            double mid = lo + (hi - lo) / 2;
            double midPow = Math.pow(mid, n);
            if(midPow < x) {
                lo = mid;
            } else if (midPow > x) {
                hi = mid;
            }
        }

        return hi;
    }
}
